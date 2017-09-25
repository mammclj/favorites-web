package com.mmm.springboot.favoritesweb.repository;

import com.mmm.springboot.favoritesweb.domain.UrlLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 13:59
 */
public interface UrlLibraryRepository extends JpaRepository<UrlLibrary, Long> {

    List<UrlLibrary> findByCountLessThanAndLogoUrl(int count, String str);

    @Transactional
    @Modifying
    @Query("update UrlLibrary u set u.count=u.count+1 where u.id =:id ")
    int increaseCountById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update UrlLibrary u set u.logoUrl = ?2 where u.id = ?1")
    int updateLogoUrlById(Long id, String logoUrl);

}