package net.northking.cloudplatform.config;

import net.northking.cloudplatform.interceptor.RepeatInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @Title:
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2018/1/4
 * @UpdateUser:
 * @Version:0.1
 */
@Configuration
public class WebAppConfig extends org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter {

    @Autowired
    private RepeatInterceptor repeatInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(repeatInterceptor).addPathPatterns("/**").excludePathPatterns("/identifyCode/generate");
    }

}
