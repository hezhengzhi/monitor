package com.bridge.monitor.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Description: null
 * Author: hezhengzhi
 * Date: 2021-02-16 17:06:41
 */

@Data
public class UserInVo {


    @ApiModelProperty(name = "id", value = "主键")
    private Integer id;

    @ApiModelProperty(name = "nickName", value = "昵称")
    private String nickName;

    @ApiModelProperty(name = "name", value = "账号")
    private String name;

    @ApiModelProperty(name = "password", value = "密码")
    private String password;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(name = "phone", value = "手机号")
    private String phone;
}
