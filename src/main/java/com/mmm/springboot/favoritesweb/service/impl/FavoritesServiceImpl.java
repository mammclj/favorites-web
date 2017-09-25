package com.mmm.springboot.favoritesweb.service.impl;

import com.mmm.springboot.favoritesweb.domain.Favorites;
import com.mmm.springboot.favoritesweb.repository.FavoritesRepository;
import com.mmm.springboot.favoritesweb.service.FavoritesService;
import com.mmm.springboot.favoritesweb.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("favoritesService")
public class FavoritesServiceImpl implements FavoritesService {
	
	@Autowired
	private FavoritesRepository favoritesRepository;
	
	/**
	 * 保存
	 * @param userId
	 * @param count
	 * @param name
	 * @return
	 */
	public Favorites saveFavorites(Long userId, Long count, String name){
		Favorites favorites = new Favorites();
		favorites.setName(name);
		favorites.setUserId(userId);
		favorites.setCount(count);
		favorites.setCreateTime(DateUtils.getCurrentTime());
		favorites.setLastModifyTime(DateUtils.getCurrentTime());
		favoritesRepository.save(favorites);
		return favorites;
	}

}
