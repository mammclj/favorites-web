package com.mmm.springboot.favoritesweb.domain.view;
/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 12:03
 */
public interface CommentView {
	Long getUserId();
	String getUserName();
	String getProfilePicture();
	String getContent();
	Long getCreateTime();
	Long getReplyUserId();
}
