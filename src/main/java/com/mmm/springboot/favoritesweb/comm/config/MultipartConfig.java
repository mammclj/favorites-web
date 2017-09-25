package com.mmm.springboot.favoritesweb.comm.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 11:54
 */

@Configuration
public class MultipartConfig {
	
	@Bean  
	public MultipartConfigElement multipartConfigElement() {  
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("50MB");
		factory.setMaxRequestSize("50MB");  
		return factory.createMultipartConfig();  
	} 

}
