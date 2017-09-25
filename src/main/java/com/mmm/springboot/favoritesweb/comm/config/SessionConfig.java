package com.mmm.springboot.favoritesweb.comm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 12:00
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class SessionConfig {
	
}