package com.mmm.springboot.favoritesweb.repository;

/**
 *@Description: 获取收藏家
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 13:46
 */
public interface CollectorRepository {

    Long getMostCollectUser();

    Long getMostFollowedUser(Long notUserId);

    Long getMostPraisedUser(String notUserIds);

    Long getMostCommentedUser(String notUserIds);

    Long getMostPopularUser(String notUserIds);

    Long getMostActiveUser(String notUserIds);

}
