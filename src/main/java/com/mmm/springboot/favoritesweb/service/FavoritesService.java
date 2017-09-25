package com.mmm.springboot.favoritesweb.service;

import com.mmm.springboot.favoritesweb.domain.Favorites;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:01
 */
public interface FavoritesService {
	
	public Favorites saveFavorites(Long userId, Long count, String name);

}
