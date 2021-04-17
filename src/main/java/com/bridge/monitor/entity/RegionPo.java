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

/**
 * Description: 区域信息表 
 * Author: hezhengzhi
 * Date: 2021-04-11 15:28:47 
 */

@Data
@Entity
@Builder
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table (name ="bm_region")
@TableName (value ="bm_region")
public class RegionPo  implements Serializable {

	private static final long serialVersionUID =  2606359230210867497L;

	/**
	 * 区域主键
	 */
	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 区域名称
	 */
	@Column(name = "name" )
	private String name;

	/**
	 * 区域上级标识
	 */
	@Column(name = "pid" )
	private Integer pid;

	/**
	 * 地名简称
	 */
	@Column(name = "sname" )
	private String sname;

	/**
	 * 区域等级
	 */
	@Column(name = "level" )
	private Integer level;

	/**
	 * 区域编码
	 */
	@Column(name = "citycode" )
	private String citycode;

	/**
	 * 邮政编码
	 */
	@Column(name = "yzcode" )
	private String yzcode;

	/**
	 * 组合名称
	 */
	@Column(name = "mername" )
	private String mername;

	/**
	 * 经度
	 */
	@Column(name = "Lng" )
	private Double lng;

	/**
	 * 纬度
	 */
	@Column(name = "Lat" )
	private Double lat;

	/**
	 * 拼音
	 */
	@Column(name = "pinyin" )
	private String pinyin;

}
