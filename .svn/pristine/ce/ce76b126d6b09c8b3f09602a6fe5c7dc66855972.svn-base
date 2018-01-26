package net.northking.cloudplatform.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Title:
 * @Description: BCryptPasswordEncoder工具类
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-11-27 12:09
 * @UpdateUser:
 * @Version:0.1
 */

@Configuration
public class BCryptPasswordEncoderUtil {


  @Bean
    public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }



}
