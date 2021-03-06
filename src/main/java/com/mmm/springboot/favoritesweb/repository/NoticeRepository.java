package com.mmm.springboot.favoritesweb.repository;

import javax.transaction.Transactional;

import com.mmm.springboot.favoritesweb.domain.Notice;
import com.mmm.springboot.favoritesweb.domain.view.CollectView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 13:59
 */
public interface NoticeRepository extends JpaRepository<Notice, Long> {

	public String baseSql="select c.id as id,c.title as title, c.type as type,c.url as url,c.logoUrl as logoUrl,c.userId as userId, "
			+ "c.remark as remark,c.description as description,c.lastModifyTime as lastModifyTime, "
			+ "u.userName as userName,u.profilePicture as profilePicture,n.operId as operId "
			+ "from Notice n,Collect c,User u WHERE n.collectId=c.id and c.userId=u.id";
	
	@Query(baseSql+ " and n.userId=?1 and n.type=?2")
	Page<CollectView> findViewByUserIdAndType(Long userId, String type, Pageable pageable);
	
	Long countByUserIdAndTypeAndReaded(Long userId, String type, String readed);
	
	@Query("select count(1) from Notice n,Praise p where n.operId=p.id and type='praise' and n.userId=?1 and n.readed=?2")
	Long countPraiseByUserIdAndReaded(Long userId, String readed);
	
	@Transactional
	@Modifying
	@Query("update Notice n set n.readed = ?1 where n.userId = ?2 and n.type = ?3 and n.readed='unread'")
	int updateReadedByUserId(String readed, long userId, String type);

}