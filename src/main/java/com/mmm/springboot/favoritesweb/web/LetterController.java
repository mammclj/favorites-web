package com.mmm.springboot.favoritesweb.web;

import com.mmm.springboot.favoritesweb.comm.aop.LoggerManage;
import com.mmm.springboot.favoritesweb.domain.Letter;
import com.mmm.springboot.favoritesweb.domain.result.ExceptionMsg;
import com.mmm.springboot.favoritesweb.domain.result.Response;
import com.mmm.springboot.favoritesweb.domain.view.LetterSummary;
import com.mmm.springboot.favoritesweb.service.LetterService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:31
 */
@RestController
@RequestMapping("/letter")
public class LetterController extends BaseController {

    @Resource
    private LetterService letterService;

    /**
     * 发送私信
     * @param letter
     * @return
     */
    @RequestMapping("/sendLetter")
    @LoggerManage(description = "发送私信")
    public Response sendLetter(Letter letter){
        try {
            letter.setSendUserId(getUserId());
            letterService.sendLetter(letter);
        }catch (Exception e){
            logger.error("发送私信异常：",e);
            return result(ExceptionMsg.FAILED);
        }
        return result();
    }

    /**
     * 私信列表获取
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/getLetterList")
    @LoggerManage(description = "获取私信列表")
    public List<LetterSummary> getLetterList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                             @RequestParam(value = "size", defaultValue = "15") Integer size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        List<LetterSummary> letterList = letterService.findLetter(getUserId(),pageable);
        return letterList;
    }
}
