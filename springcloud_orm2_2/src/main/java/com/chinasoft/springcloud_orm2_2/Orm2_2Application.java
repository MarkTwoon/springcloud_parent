package com.chinasoft.springcloud_orm2_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
@EnableCircuitBreaker
public class Orm2_2Application {

    public static void main(String[] args) {
        SpringApplication.run(Orm2_2Application.class, args);
    }

}
