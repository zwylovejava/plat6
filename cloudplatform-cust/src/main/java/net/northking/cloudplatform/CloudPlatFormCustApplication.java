package net.northking.cloudplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
@MapperScan("net.northking.cloudplatform.dao")
@SpringCloudApplication
@EnableFeignClients
public class CloudPlatFormCustApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudPlatFormCustApplication.class,args);
    }



}

