package com.mmm.springboot.favoritesweb.service;
/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 14:14
 */
public interface RedisService {

    public void  set(String key, String value);

    public String get(String key);

    public void  setObject(String key, Object value);

    public Object getObject(String key);

    public boolean expire(String key, long timeout);

    public void delete(String key);

}
