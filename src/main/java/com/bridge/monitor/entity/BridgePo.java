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
 * Description: 桥梁信息表 
 * Author: hezhengzhi
 * Date: 2021-04-17 22:58:28 
 */

@Data
@Entity
@Builder
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table (name ="bm_bridge")
@TableName (value ="bm_bridge")
public class BridgePo  implements Serializable {

	private static final long serialVersionUID =  7519096460933011924L;

	/**
	 * 主键
	 */
	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 桥梁名
	 */
	@Column(name = "bridge_name" )
	private String bridgeName;

	/**
	 * 省
	 */
	@Column(name = "province" )
	private String province;

	/**
	 * 市
	 */
	@Column(name = "city" )
	private String city;

	/**
	 * 区
	 */
	@Column(name = "area" )
	private String area;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 创建人id
	 */
	@Column(name = "create_user_id" )
	private Integer createUserId;

	/**
	 * 创建人名称
	 */
	@Column(name = "create_user_name" )
	private String createUserName;

	/**
	 * 更新时间
	 */
	@Column(name = "update_time" )
	private Date updateTime;

	@Column(name = "address" )
	private String address;

	@Column(name = "update_user_id" )
	private Integer updateUserId;

	/**
	 * 省id
	 */
	@Column(name = "province_id" )
	private Integer provinceId;

	/**
	 * 市id
	 */
	@Column(name = "city_id" )
	private Integer cityId;

	/**
	 * 区id
	 */
	@Column(name = "area_id" )
	private Integer areaId;

}
