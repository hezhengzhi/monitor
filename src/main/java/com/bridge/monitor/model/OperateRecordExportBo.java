package com.bridge.monitor.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Description: 操作记录表 
 * Author: hezhengzhi
 * Date: 2021-03-19 01:02:39 
 */

@Data
public class OperateRecordExportBo {


	@ExcelProperty(value = "操作内容",index = 1)
	private String content;

	@ExcelProperty(value = "操作人账号",index = 2)
	private String userName;

	@ExcelProperty(value = "操作人中文名",index = 3)
	private String nickName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelProperty(value = "操作时间",index = 4)
	private Date createTime;

}
