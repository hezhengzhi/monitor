package com.bridge.monitor.controller;

import com.bridge.monitor.entity.OperateRecordPo;
import com.bridge.monitor.entity.UserPo;
import com.bridge.monitor.model.OperateRecordInVo;
import com.bridge.monitor.service.OperateRecordService;
import com.bridge.monitor.util.HttpResponse;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author hezhengzhi
 * @description 操作记录
 * @date 2021/3/18 23:19
 **/
@Api(tags = "操作记录")
@RestController
@RequestMapping(value = "/operate/record")
@Slf4j
public class OperateRecordController {
    @Resource
    private OperateRecordService operateRecordService;

    @GetMapping(value = "/findAll")
    @ApiOperation(value = "查询操作记录", notes = "查询操作记录")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "操作人姓名", name = "userName",paramType = "query"),
            @ApiImplicitParam(value = "分页大小", name = "pageSize", required = true, defaultValue = "20",paramType = "query"),
            @ApiImplicitParam(value = "分页页码", name = "pageNum", required = true, defaultValue = "1",paramType = "query")
    })
    public HttpResponse<Page<OperateRecordPo>> findAll(String userName, int pageSize, int pageNum) {
        return operateRecordService.findAll(userName, pageNum, pageSize);
    }

    @GetMapping(value = "/delete/{ids}")
    @ApiOperation(value = "删除操作记录", notes = "删除操作记录")
    public HttpResponse<String> delete(
            @PathVariable(value = "ids") @ApiParam(value = "删除的id，多个用英文逗号分割", name = "ids", required = true) String ids) {
        if (StringUtils.isEmpty(ids))
            return HttpResponse.FAIL(HttpStatus.INTERNAL_SERVER_ERROR.value(), "删除id不能为空");
        List<String> idList = CollectionUtils.asList(StringUtils.split(ids, ","));
        return operateRecordService.deleteByIdList(idList);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "新增操作记录", notes = "新增操作记录")
    public HttpResponse<OperateRecordPo> save(@Valid @RequestBody OperateRecordInVo operateRecordInVo) {
        Subject subject = SecurityUtils.getSubject();
        UserPo userPo = (UserPo) subject.getPrincipal();
        operateRecordInVo.setCreateTime(new Date());
        operateRecordInVo.setUserId(userPo.getId());
        operateRecordInVo.setUserName(userPo.getName());
        operateRecordInVo.setNickName(userPo.getNickName());
        return operateRecordService.save(operateRecordInVo);
    }

    @PostMapping(value = "/export")
    @ApiOperation(value = "导出操作记录", notes = "导出操作记录" ,produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ApiImplicitParam(value = "操作人姓名", name = "userName",paramType = "query")
    public void export(HttpServletResponse response, String userName) {
        operateRecordService.export(userName, response);
    }
}
