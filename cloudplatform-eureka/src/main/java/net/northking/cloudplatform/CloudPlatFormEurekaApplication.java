package net.northking.cloudplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudPlatFormEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudPlatFormEurekaApplication.class,args);
    }
}
