package com.bridge.monitor.repo;

import com.bridge.monitor.util.HttpResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.bridge.monitor.entity.OperateRecordPo;

import java.util.List;

/**
 * Description: nullRepo 
 * Author: hezhengzhi
 * Date: 2021-03-18 23:10:21 
 */

public interface OperateRecordRepo  extends JpaRepository<OperateRecordPo,Integer>,JpaSpecificationExecutor<OperateRecordPo> {
    void deleteByIdIn(List<?> idList);

    List<OperateRecordPo> findByUserNameLikeAndIsDelete(String s, int i);
}
