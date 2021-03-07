package com.chinasoft.springcloud_eurake3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eurake3Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurake3Application.class, args);
    }

}
