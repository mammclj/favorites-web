package com.mmm.springboot.favoritesweb.service;

import com.mmm.springboot.favoritesweb.domain.Letter;
import com.mmm.springboot.favoritesweb.domain.view.LetterSummary;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:02
 */
public interface LetterService {

    public void sendLetter(Letter letter);

    public List<LetterSummary> findLetter(Long userId, Pageable pageable);
}
