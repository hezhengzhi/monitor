package com.bridge.monitor.entity;

import lombok.Data;
import lombok.Builder;
import lombok.ToString;
import java.io.Serializable;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
 * Description: 采集记录表 
 * Author: hezhengzhi
 * Date: 2021-03-04 19:17:41 
 */

@Data
@Entity
@Builder
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table (name ="bm_monitor_record")
@TableName (value ="bm_monitor_record")
public class MonitorRecordPo  implements Serializable {

	private static final long serialVersionUID =  2274128925286415196L;

	/**
	 * 主键
	 */
	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 采集的文件名
	 */
	@Column(name = "file_name" )
	private String fileName;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 更新时间
	 */
	@Column(name = "update_time" )
	private Date updateTime;

}
