package com.bridge.monitor.repo;

import com.bridge.monitor.entity.RegionPo;
import com.bridge.monitor.util.HttpResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.bridge.monitor.entity.BridgePo;

import java.util.List;

/**
 * Description: 桥梁信息表Repo 
 * Author: hezhengzhi
 * Date: 2021-04-11 15:28:38 
 */

public interface BridgeRepo  extends JpaRepository<BridgePo,Integer>,JpaSpecificationExecutor<BridgePo> {
}
