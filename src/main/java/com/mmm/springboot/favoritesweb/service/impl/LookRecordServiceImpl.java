package com.mmm.springboot.favoritesweb.service.impl;

import com.mmm.springboot.favoritesweb.domain.LookRecord;
import com.mmm.springboot.favoritesweb.domain.Praise;
import com.mmm.springboot.favoritesweb.domain.view.CollectSummary;
import com.mmm.springboot.favoritesweb.domain.view.CollectView;
import com.mmm.springboot.favoritesweb.repository.CommentRepository;
import com.mmm.springboot.favoritesweb.repository.LookRecordRepository;
import com.mmm.springboot.favoritesweb.repository.PraiseRepository;
import com.mmm.springboot.favoritesweb.service.CollectService;
import com.mmm.springboot.favoritesweb.service.LookRecordService;
import com.mmm.springboot.favoritesweb.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:16
 */
@Service("lookRecordService")
public class LookRecordServiceImpl implements LookRecordService {

    @Autowired
    private LookRecordRepository lookRecordRepository;

    @Autowired
    private PraiseRepository praiseRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CollectService collectService;




    @Override
    public void saveLookRecord(Long userId,Long collectId) {
        if(userId != null && userId > 0 && collectId != null) {
            Integer count = lookRecordRepository.countByUserIdAndCollectId(userId, collectId);
            if (count > 0) {
                lookRecordRepository.updatelastModifyTime(userId, collectId, DateUtils.getCurrentTime());
            } else {
                LookRecord lookRecord = new LookRecord();
                lookRecord.setUserId(userId);
                lookRecord.setCollectId(collectId);
                lookRecord.setCreateTime(DateUtils.getCurrentTime());
                lookRecord.setLastModifyTime(DateUtils.getCurrentTime());
                lookRecordRepository.save(lookRecord);
            }
        }

    }

    @Override
    public void deleteLookRecord(Long userId, Long collectId) {
        lookRecordRepository.deleteByUserIdAndCollectId(userId,collectId);
    }

    @Override
    public void deleteLookRecordByUserID(Long userId) {
        lookRecordRepository.deleteByUserId(userId);
    }

    @Override
    public List<CollectSummary> getLookRecords(Long userId, Pageable pageable) {
        Page<CollectView> views = null;

        views = lookRecordRepository.findViewByUserId(userId, pageable);

        return convertCollect(views,userId);
    }

    /**
     * @author neo
     * @date 2016年8月11日
     * @return
     */
    private List<CollectSummary> convertCollect(Page<CollectView> views,Long userId) {
        List<CollectSummary> summarys=new ArrayList<CollectSummary>();
        for (CollectView view : views) {
            CollectSummary summary=new CollectSummary(view);
            summary.setPraiseCount(praiseRepository.countByCollectId(view.getId()));
            summary.setCommentCount(commentRepository.countByCollectId(view.getId()));
            Praise praise=praiseRepository.findByUserIdAndCollectId(userId, view.getId());
            if(praise!=null){
                summary.setPraise(true);
            }else{
                summary.setPraise(false);
            }
            summary.setCollectTime(DateUtils.getTimeFormatText(view.getCreateTime()));
            summarys.add(summary);
        }
        return summarys;
    }


}
