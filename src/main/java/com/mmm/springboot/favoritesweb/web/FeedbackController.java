package com.mmm.springboot.favoritesweb.web;

import com.mmm.springboot.favoritesweb.domain.Feedback;
import com.mmm.springboot.favoritesweb.domain.result.ExceptionMsg;
import com.mmm.springboot.favoritesweb.domain.result.Response;
import com.mmm.springboot.favoritesweb.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:34
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController extends BaseController{
    @Autowired
    private FeedbackService feedbackService;

    /**
     * @author chenzhimin
     * @date 2017年1月23日
     * @return
     */
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Response save(Feedback feedback) {
        try {
        feedbackService.saveFeeddback(feedback,getUserId());
        } catch (Exception e) {
            logger.error("feedback failed, ", e);
            return result(ExceptionMsg.FAILED);
        }
        return result();
    }
}
