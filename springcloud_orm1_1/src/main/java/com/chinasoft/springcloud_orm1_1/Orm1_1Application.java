package com.chinasoft.springcloud_orm1_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
@EnableCircuitBreaker
public class  Orm1_1Application {

    public static void main(String[] args) {
        SpringApplication.run(Orm1_1Application.class, args);
    }

}
