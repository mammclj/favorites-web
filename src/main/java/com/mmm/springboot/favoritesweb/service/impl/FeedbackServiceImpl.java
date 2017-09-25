package com.mmm.springboot.favoritesweb.service.impl;

import com.mmm.springboot.favoritesweb.domain.Feedback;
import com.mmm.springboot.favoritesweb.repository.FeedbackRepository;
import com.mmm.springboot.favoritesweb.service.FeedbackService;
import com.mmm.springboot.favoritesweb.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:14
 */
@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public void saveFeeddback(Feedback feedback, Long userId) {
        feedback.setUserId(userId == null || userId == 0L ? null : userId);
        feedback.setCreateTime(DateUtils.getCurrentTime());
        feedback.setLastModifyTime(DateUtils.getCurrentTime());
        feedbackRepository.save(feedback);
    }
}
