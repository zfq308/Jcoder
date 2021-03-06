package org.nlpcn.jcoder.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Table("user")
public class User implements Serializable {

	public static final User CLUSTER_USER = new User();

	static {
		CLUSTER_USER.setId((long) -1);
		CLUSTER_USER.setName("cluster");
		CLUSTER_USER.setCreateTime(new Date());
		CLUSTER_USER.setMail("cluster@jcoder.com");
		CLUSTER_USER.setPassword("");
		CLUSTER_USER.type = 1;
	}

	@Id
	private Long id;

	@Column
	private String name;

	@Column
	private String password;

	@Column("type")
	private int type; // 用户类型 0游客 1管理员

	@Column
	private String mail; // 用户邮箱

	@Column("create_time")
	private Date createTime; // 创建时间

	//扩展用户的属性字段
	private Map<String, Object> attr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		if (this.id == -1 && type != 1) { //cluster user不让改类型
			throw new RuntimeException("cluster user must not modify");
		}
		this.type = type;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	/**
	 * 通用属性的拓展添加。不是线程安全的
	 */
	public void put(String key, Object value) {
		if (attr == null) {
			attr = new HashMap<>();
		}
		this.attr.put(key, value);
	}

	/**
	 * 获得属性
	 */
	public Object get(String key) {
		if (attr == null) {
			return null;
		}
		return attr.get(key);
	}

}
