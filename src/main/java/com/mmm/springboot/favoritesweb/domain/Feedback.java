package com.mmm.springboot.favoritesweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户反馈javaBean类
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 12:03
 */
@Entity
public class Feedback  extends Entitys implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = true)
    private Long userId;
    @Column(nullable = false)
    private String feedbackAdvice;
    @Column(nullable = true)
    private String feedbackName;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private Long createTime;
    @Column(nullable = false)
    private Long lastModifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFeedbackAdvice() {
        return feedbackAdvice;
    }

    public void setFeedbackAdvice(String feedbackAdvice) {
        this.feedbackAdvice = feedbackAdvice;
    }

    public String getFeedbackName() {
        return feedbackName;
    }

    public void setFeedbackName(String feedbackName) {
        this.feedbackName = feedbackName;
    }
}
