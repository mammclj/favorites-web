package com.mmm.springboot.favoritesweb.service;

import com.mmm.springboot.favoritesweb.domain.Feedback;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:01
 */
public interface FeedbackService {

    public void saveFeeddback(Feedback feedback, Long userId);
}
