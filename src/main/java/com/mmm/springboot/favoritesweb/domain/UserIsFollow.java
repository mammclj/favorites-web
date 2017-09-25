package com.mmm.springboot.favoritesweb.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 随便看看右侧关注使用
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 12:05
 */
@Entity
public class UserIsFollow implements Serializable{
    @Id
    private Long id;
    private String userName;
    private String profilePicture;
    private String isFollow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(String isFollow) {
        this.isFollow = isFollow;
    }
}
