package com.bridge.monitor.dao;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bridge.monitor.entity.UserPo;

/**
 * Description: nullMapper 
 * Author: hezhengzhi
 * Date: 2021-02-26 20:27:23 
 */

@Mapper
public interface UserMapper extends BaseMapper<UserPo> {

}
