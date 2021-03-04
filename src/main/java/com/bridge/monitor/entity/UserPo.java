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
 * Description: null 
 * Author: hezhengzhi
 * Date: 2021-02-26 22:54:36 
 */

@Data
@Entity
@Builder
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table (name ="bm_user")
@TableName (value ="bm_user")
public class UserPo  implements Serializable {

	private static final long serialVersionUID =  7779262256602298117L;

	/**
	 * 主键
	 */
	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 昵称
	 */
	@Column(name = "nick_name" )
	private String nickName;

	/**
	 * 账号
	 */
	@Column(name = "name" )
	private String name;

	/**
	 * 密码
	 */
	@Column(name = "password" )
	private String password;

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

	/**
	 * 手机号
	 */
	@Column(name = "phone" )
	private Integer phone;

}
