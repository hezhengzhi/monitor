package com.bridge.monitor.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Description: 操作记录表 
 * Author: hezhengzhi
 * Date: 2021-03-19 01:02:39 
 */

@Data
public class OperateRecordInVo {


	@ApiModelProperty(name = "id",value = "主键id")
	private Integer id;

	@ApiModelProperty(name = "content",value = "操作内容")
	private String content;

	@ApiModelProperty(name = "userId",value = "操作人id")
	private Integer userId;

	@ApiModelProperty(name = "userName",value = "操作人姓名")
	private String userName;

	@ApiModelProperty(name = "nickName",value = "中文名")
	private String nickName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(name = "createTime",value = "操作时间")
	private Date createTime;

	@ApiModelProperty(name = "isDelete",value = "是否删除 0否1是")
	private Integer isDelete;

	@ApiModelProperty(name = "updateTime",value = "更新时间")
	private Date updateTime;

	@ApiModelProperty(name = "updateUserId",value = "更新人id")
	private Integer updateUserId;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(name = "updateUserName",value = "更新人姓名")
	private String updateUserName;

}
