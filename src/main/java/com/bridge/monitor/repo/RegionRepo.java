package com.bridge.monitor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.bridge.monitor.entity.RegionPo;

import java.util.List;

/**
 * Description: 区域信息表Repo 
 * Author: hezhengzhi
 * Date: 2021-04-11 15:28:53 
 */

public interface RegionRepo  extends JpaRepository<RegionPo,Integer>,JpaSpecificationExecutor<RegionPo> {
    List<RegionPo> findByLevelAndPid(Integer level, Integer pid);

    List<RegionPo> findByLevel(int level);
}
