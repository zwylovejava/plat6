package net.northking.cloudplatform;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("net.northking.cloudplatform.dao")
@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@EnableFeignClients
@ComponentScan("net.northking.cloudplatform")
public class CloudplatformDictionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudplatformDictionaryApplication.class, args);
	}


}
