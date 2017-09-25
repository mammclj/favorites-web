package com.mmm.springboot.favoritesweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class FavoritesWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(FavoritesWebApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(FavoritesWebApplication.class, args);
	}
}
