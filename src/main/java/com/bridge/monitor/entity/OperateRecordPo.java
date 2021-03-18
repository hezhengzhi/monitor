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
 * Description: 操作记录表 
 * Author: hezhengzhi
 * Date: 2021-03-19 01:02:31 
 */

@Data
@Entity
@Builder
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table (name ="bm_operate_record")
@TableName (value ="bm_operate_record")
public class OperateRecordPo  implements Serializable {

	private static final long serialVersionUID =  5083291431194940036L;

	/**
	 * 主键id
	 */
	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 操作内容
	 */
	@Column(name = "content" )
	private String content;

	/**
	 * 操作人id
	 */
	@Column(name = "user_id" )
	private Integer userId;

	/**
	 * 操作人姓名
	 */
	@Column(name = "user_name" )
	private String userName;

	/**
	 * 中文名
	 */
	@Column(name = "nick_name" )
	private String nickName;

	/**
	 * 操作时间
	 */
	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 是否删除 0否1是
	 */
	@Column(name = "is_delete" )
	private Integer isDelete;

	/**
	 * 更新时间
	 */
	@Column(name = "update_time" )
	private Date updateTime;

	/**
	 * 更新人id
	 */
	@Column(name = "update_user_id" )
	private Integer updateUserId;

	/**
	 * 更新人姓名
	 */
	@Column(name = "update_user_name" )
	private String updateUserName;

}
