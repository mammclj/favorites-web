package com.mmm.springboot.favoritesweb.service;


import com.mmm.springboot.favoritesweb.domain.view.CollectSummary;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:03
 */
public interface NoticeService {
	
	public void saveNotice(String collectId, String type, Long userId, String operId);
	
	public List<CollectSummary> getNoticeCollects(String type, Long userId, Pageable pageable);

}
