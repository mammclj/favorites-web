package com.mmm.springboot.favoritesweb.comm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 *@Author 马孟孟【mamengmeng@msymobile.com】
 *@Date 2017/9/25 11:54
 */
@Component
public class Config{
		
	@Value("${favorites.file.save.path}")
	private String savePath;
	@Value("${favorites.file.access.url}")
	private String accessUrl;
	
	
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getAccessUrl() {
		return accessUrl;
	}
	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}
	
	

}