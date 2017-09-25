package com.mmm.springboot.favoritesweb.service;

import com.mmm.springboot.favoritesweb.domain.Config;
/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:05
 */
public interface ConfigService {
	
	public Config saveConfig(Long userId, String favoritesId);

	public void updateConfig(Long id, String type, String defaultFavorites);
}
