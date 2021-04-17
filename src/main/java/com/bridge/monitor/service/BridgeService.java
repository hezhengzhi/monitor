package com.bridge.monitor.service;

import com.bridge.monitor.entity.BridgePo;
import com.bridge.monitor.entity.RegionPo;
import com.bridge.monitor.entity.UserPo;
import com.bridge.monitor.model.BridgeInVo;
import com.bridge.monitor.repo.BridgeRepo;
import com.bridge.monitor.repo.RegionRepo;
import com.bridge.monitor.util.HttpResponse;
import io.swagger.models.auth.In;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;

@Service
public class BridgeService {
    @Resource
    private BridgeRepo bridgeRepo;

    @Resource
    private RegionRepo regionRepo;

    public HttpResponse<List<RegionPo>> findRegion(int level, Integer pid) {
        List<RegionPo> regionPoList;
        if (pid == null) {
            regionPoList = regionRepo.findByLevel(level);
        } else {
            regionPoList = regionRepo.findByLevelAndPid(level, pid);
        }
        return HttpResponse.SUCCESS(regionPoList);
    }

    public HttpResponse<Page<BridgePo>> findBridge(Integer areaId, String bridgeName, int pageSize, int pageNum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize, sort);
        Page<BridgePo> bridgeList =bridgeRepo .findAll((Specification<BridgePo>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (!StringUtils.isEmpty(bridgeName)) {
                predicate.getExpressions().add(criteriaBuilder.like(root.get("bridgeName"), "%" + bridgeName + "%"));
            }
            if (areaId!=null) {
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("areaId"), "%" + areaId + "%"));
            }
            return predicate;
        }, pageRequest);
        return HttpResponse.SUCCESS(bridgeList);
    }

    public HttpResponse<String> save(BridgeInVo bridgeInVo) {
        BridgePo bridgePo =new BridgePo();
        BeanUtils.copyProperties(bridgeInVo,bridgePo);
        UserPo userPo=(UserPo) SecurityUtils.getSubject().getPrincipal();
        if (bridgePo.getId()==null){
            bridgePo.setCreateTime(new Date());
            bridgePo.setCreateUserId(userPo.getId());
            bridgePo.setCreateUserName(userPo.getName());
        }
        bridgePo.setUpdateUserId(userPo.getId());
        bridgeRepo.save(bridgePo);
        return HttpResponse.SUCCESS("保存成功");
    }


    public HttpResponse<String> delete(int id) {
        bridgeRepo.deleteById(id);
        return HttpResponse.SUCCESS("删除成功");
    }
}
