package com.mmm.springboot.favoritesweb.repository;


import java.util.List;

import javax.transaction.Transactional;

import com.mmm.springboot.favoritesweb.domain.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 13:54
 */
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {

	List<Favorites> findByUserId(Long userId);
	
	List<Favorites> findByUserIdOrderByIdDesc(Long userId);
	
	Favorites findByUserIdAndName(Long userId, String name);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query("update Favorites f set f.count=(f.count+1),f.lastModifyTime =:lastModifyTime where f.id =:id")
	void increaseCountById(@Param("id") Long id, @Param("lastModifyTime") Long lastModifyTime);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query("update Favorites f set f.count=(f.count-1),f.lastModifyTime =:lastModifyTime where f.id =:id")
	void reduceCountById(@Param("id") Long id, @Param("lastModifyTime") Long lastModifyTime);

	@Modifying(clearAutomatically=true)
	@Transactional
	@Query("update Favorites set name=:name ,lastModifyTime=:lastModifyTime where id=:id")
	void updateNameById(@Param("id") Long id, @Param("lastModifyTime") Long lastModifyTime, @Param("name") String name);
	@Query("select id from Favorites where name=?1")
	List<Long> findIdByName(String name);
}