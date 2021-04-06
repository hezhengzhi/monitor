package com.bridge.monitor.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.bridge.monitor.entity.OperateRecordPo;
import com.bridge.monitor.entity.UserPo;
import com.bridge.monitor.filter.CustomRowWriteHandler;
import com.bridge.monitor.model.OperateRecordExportBo;
import com.bridge.monitor.model.OperateRecordInVo;
import com.bridge.monitor.repo.OperateRecordRepo;
import com.bridge.monitor.util.CellStyleUtil;
import com.bridge.monitor.util.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.util.CellUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OperateRecordService {
    @Resource
    private OperateRecordRepo operateRecordRepo;
    public HttpResponse<Page<OperateRecordPo>> findAll(String userName, int pageNum, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize, sort);
        Page<OperateRecordPo> operateRecordPos =operateRecordRepo .findAll((Specification<OperateRecordPo>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (!StringUtils.isEmpty(userName)) {
                predicate.getExpressions().add(criteriaBuilder.like(root.get("userName"), "%" + userName + "%"));
            }
            predicate.getExpressions().add(criteriaBuilder.equal(root.get("isDelete"),0));
            return predicate;
        }, pageRequest);
        return HttpResponse.SUCCESS(operateRecordPos);
    }

    public HttpResponse<String> deleteByIdList(List<String> idList) {
        Subject subject = SecurityUtils.getSubject();
        UserPo userPo=(UserPo)subject.getPrincipal();
        idList.stream().peek(idStr->{
            int id=Integer.parseInt(idStr);
            OperateRecordPo operateRecordPo=operateRecordRepo.findById(id).orElse(null);
            if (operateRecordPo!=null){
                operateRecordPo.setIsDelete(1);
                operateRecordPo.setUpdateUserId(userPo.getId());
                operateRecordPo.setUpdateTime(new Date());
                operateRecordPo.setUpdateUserName(userPo.getName());
                operateRecordRepo.save(operateRecordPo);
            }
            System.out.println(idStr);
        }).collect(Collectors.toList());
        return HttpResponse.SUCCESS("删除成功");
    }

    public HttpResponse<OperateRecordPo> save(OperateRecordInVo operateRecordInVo) {
        OperateRecordPo operateRecordPo=new OperateRecordPo();
        BeanUtils.copyProperties(operateRecordInVo,operateRecordPo);
        operateRecordRepo.save(operateRecordPo);
        return HttpResponse.SUCCESS("保存成功");
    }

    public void export(String userName, HttpServletResponse response) {
        try(OutputStream outputStream=response.getOutputStream()) {
            String excelName = "operateRecord.xlsx";
            response.setHeader("Content-disposition", "attachment; filename=" + excelName);
            List<OperateRecordPo>operateRecordPos=new ArrayList<>();
            if (StringUtils.isEmpty(userName)){
                operateRecordPos=operateRecordRepo.findByIsDelete(0);
            }else {
                operateRecordPos=operateRecordRepo.findByUserNameLikeAndIsDelete("%"+userName+"%",0);
            }
            List<OperateRecordExportBo>operateRecordExportBos=operateRecordPos.stream().map(operateRecordPo -> {
                OperateRecordExportBo operateRecordExportBo=new OperateRecordExportBo();
                BeanUtils.copyProperties(operateRecordPo,operateRecordExportBo);
                return operateRecordExportBo;
            }).collect(Collectors.toList());

            response.setHeader("Content-disposition", "attachment; filename=" + excelName);
            EasyExcel.write(outputStream, OperateRecordExportBo.class)
                    .registerWriteHandler(CellStyleUtil.getHorizontalCellStyleStrategy())
                    .registerWriteHandler(new CustomRowWriteHandler()).sheet("操作记录导出")
                   .doWrite(operateRecordExportBos);
            outputStream.flush();
        }catch (Exception e){
            log.error("操作记录导出失败  "+e.getMessage(),e.getMessage());
        }
    }
}
