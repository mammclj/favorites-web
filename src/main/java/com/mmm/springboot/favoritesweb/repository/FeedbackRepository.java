package com.mmm.springboot.favoritesweb.repository;


import com.mmm.springboot.favoritesweb.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 13:55
 */
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
