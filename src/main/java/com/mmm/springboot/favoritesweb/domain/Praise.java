package com.mmm.springboot.favoritesweb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 点赞
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 12:04
 */
@Entity
public class Praise extends Entitys implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private Long collectId;
	@Column(nullable = false)
	private Long userId;
	@Column(nullable = false)
	private Long createTime;

	public Praise() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCollectId() {
		return collectId;
	}

	public void setCollectId(Long collectId) {
		this.collectId = collectId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

}