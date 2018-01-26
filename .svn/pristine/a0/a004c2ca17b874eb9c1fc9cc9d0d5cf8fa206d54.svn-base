package net.northking.cloudplatform;

import net.northking.cloudplatform.security.SecurityUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;


@MapperScan("net.northking.cloudplatform.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class CloudPlatFormAuthApplication {
    @Bean(name = "auditorAware")
    public AuditorAware<String> auditorAware() {
        return ()-> SecurityUtils.getCurrentUserUsername();
    }
    public static void main(String[] args) {
        SpringApplication.run(CloudPlatFormAuthApplication.class,args);
    }

}
