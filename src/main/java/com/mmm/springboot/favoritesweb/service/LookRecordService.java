package com.mmm.springboot.favoritesweb.service;

import com.mmm.springboot.favoritesweb.domain.view.CollectSummary;
import org.springframework.data.domain.Pageable;

import java.util.List;
/**
 *浏览记录service接口
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:02
 */
public interface LookRecordService {

    public void saveLookRecord(Long userId, Long collectId);

    public void deleteLookRecord(Long userId, Long collectId);

    public void deleteLookRecordByUserID(Long userId);

    public List<CollectSummary> getLookRecords(Long userId, Pageable pageable);

}
