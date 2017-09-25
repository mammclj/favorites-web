package com.mmm.springboot.favoritesweb.service.impl;

import com.mmm.springboot.favoritesweb.domain.view.IndexCollectorView;
import com.mmm.springboot.favoritesweb.repository.CollectorRepository;
import com.mmm.springboot.favoritesweb.repository.UserRepository;
import com.mmm.springboot.favoritesweb.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *@Description: 获取收藏家
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:04
 */
@Service
public class CollectorServiceImpl implements CollectorService {

    @Autowired
    private CollectorRepository collectorRepository;
    @Autowired
    private UserRepository userRepository;


    /**
     * 获取收藏家
     * @return
     */
    @Override
    public IndexCollectorView getCollectors() {
        IndexCollectorView indexCollectorView = new IndexCollectorView();
        try {
            Long mostCollectUser = collectorRepository.getMostCollectUser();
            indexCollectorView.setMostCollectUser(userRepository.findById(mostCollectUser));
            Long mostFollowedUser = collectorRepository.getMostFollowedUser(mostCollectUser);
            indexCollectorView.setMostFollowedUser(userRepository.findById(mostFollowedUser));
            String notUserIds = mostCollectUser+","+mostFollowedUser;
            Long mostPraisedUser = collectorRepository.getMostPraisedUser(notUserIds);
            indexCollectorView.setMostPraisedUser(userRepository.findById(mostPraisedUser));
            notUserIds += ","+mostPraisedUser;
            Long mostCommentedUser = collectorRepository.getMostCommentedUser(notUserIds);
            indexCollectorView.setMostCommentedUser(userRepository.findById(mostCommentedUser));
            notUserIds += ","+ mostCommentedUser;
            Long mostPopularUser = collectorRepository.getMostPopularUser(notUserIds);
            indexCollectorView.setMostPopularUser(userRepository.findById(mostPopularUser));
            notUserIds += ","+ mostPopularUser;
            Long mostActiveUser = collectorRepository.getMostActiveUser(notUserIds);
            indexCollectorView.setMostActiveUser(userRepository.findById(mostActiveUser));
        }catch (Exception e){
            System.err.println(e);
        }

        return indexCollectorView;
    }
}
