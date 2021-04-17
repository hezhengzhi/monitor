package com.bridge.monitor.model;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * Description: 桥梁信息表 
 * Author: hezhengzhi
 * Date: 2021-04-17 20:37:32 
 */

@Data
public class BridgeInVo {


	@ApiModelProperty(name = "id",value = "主键")
	private Integer id;

	@ApiModelProperty(name = "bridgeName",value = "桥梁名")
	private String bridgeName;

	@ApiModelProperty(name = "province",value = "省")
	private String province;

	@ApiModelProperty(name = "city",value = "市")
	private String city;

	@ApiModelProperty(name = "area",value = "区")
	private String area;

	@ApiModelProperty(name = "createTime",value = "创建时间")
	private Date createTime;

	@ApiModelProperty(name = "createUserId",value = "创建人id")
	private Integer createUserId;

	@ApiModelProperty(name = "createUserName",value = "创建人名称")
	private String createUserName;

	@ApiModelProperty(name = "updateTime",value = "更新时间")
	private Date updateTime;

	@ApiModelProperty(name = "address",value = "null")
	private String address;

	@ApiModelProperty(name = "updateUserId",value = "null")
	private Integer updateUserId;

}
