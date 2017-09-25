package com.mmm.springboot.favoritesweb.repository;

import javax.transaction.Transactional;

import com.mmm.springboot.favoritesweb.domain.Comment;
import com.mmm.springboot.favoritesweb.domain.view.CommentView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 13:48
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

  public String findReplyUserSql="select u.id as userId,u.userName as userName,u.profilePicture as profilePicture,c.content as content,c.createTime as createTime,c.replyUserId as replyUserId "
      + "from Comment c,User u WHERE c.userId=u.id";
  
	Long countByCollectId(Long collectId);
	
	List<Comment> findByCollectIdOrderByIdDesc(Long collectId);
	
	@Transactional
	Long deleteById(Long id);

	
	@Query(findReplyUserSql+ " and c.id=?1")
	CommentView findReplyUser(Long id);
	
}