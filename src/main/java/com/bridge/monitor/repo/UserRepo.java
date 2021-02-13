package com.bridge.monitor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.bridge.monitor.entity.UserPo;

/**
 * Description: nullRepo 
 * Author: hezhengzhi
 * Date: 2021-02-13 18:16:33 
 */

public interface UserRepo  extends JpaRepository<UserPo,String>,JpaSpecificationExecutor<UserPo> {
    UserPo findByName(String username);
}
