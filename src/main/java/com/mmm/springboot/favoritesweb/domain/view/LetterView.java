package com.mmm.springboot.favoritesweb.domain.view;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 12:02
 */
public interface LetterView {
    Long getId();
    Long getSendUserId();
    String getSendUserName();
    String getProfilePicture();
    String getContent();
    Long getCreateTime();
    Long getPid();
    String getType();
}
