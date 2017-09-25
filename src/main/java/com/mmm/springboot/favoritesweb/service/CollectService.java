package com.mmm.springboot.favoritesweb.service;

import com.mmm.springboot.favoritesweb.domain.Collect;
import com.mmm.springboot.favoritesweb.domain.view.CollectSummary;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:04
 */
public interface CollectService {
	
	public List<CollectSummary> getCollects(String type, Long userId, Pageable pageable, Long favoritesId, Long specUserId);
	
	public void saveCollect(Collect collect);
	
	public void updateCollect(Collect newCollect);
	
	public boolean checkCollect(Collect collect);
	
	public void importHtml(Map<String, String> map, Long favoritesId, Long userId, String type);
	
	public StringBuilder exportToHtml(Long favoritesId);
	
	public List<CollectSummary> searchMy(Long userId, String key, Pageable pageable);
	
	public List<CollectSummary> searchOther(Long userId, String key, Pageable pageable);
	
	public void otherCollect(Collect collect);
	
	public void like(Long userId, long id);

}
