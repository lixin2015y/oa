package com.lee.config;

import com.lee.interceptor.PassportInterceptor;
import com.lee.interceptor.UserInfoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 */
@Component
public class ZxWebConfiguration implements WebMvcConfigurer {

    @Autowired
    PassportInterceptor passportInterceptor;

    @Autowired
    UserInfoInterceptor userInfoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInfoInterceptor).addPathPatterns("/**");
        List<String> addPatterns = new ArrayList<String>();
        addPatterns.add("/admin/index/*.html");
        addPatterns.add("/user/**");
        addPatterns.add("/flow/**");
        addPatterns.add("/login/**");
        List<String> excludePatterns = new ArrayList<String>();
        excludePatterns.add("/admin/index/login.html");
        excludePatterns.add("/login/login");
        registry.addInterceptor(passportInterceptor)
                .addPathPatterns(addPatterns)
                .excludePathPatterns(excludePatterns);
    }
}
