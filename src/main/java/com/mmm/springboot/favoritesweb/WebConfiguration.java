package com.mmm.springboot.favoritesweb;

import com.mmm.springboot.favoritesweb.comm.filter.SecurityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @Author 马孟孟【mamengmeng@msymobile.com】
 * @Date 2017/9/25 11:48
 */
public class WebConfiguration {
    @Bean
    public FilterRegistrationBean filterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SecurityFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
}
