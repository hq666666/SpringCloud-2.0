package com.person.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //开启注册中心
public class AppEureka {

    public static void main(String[] args) {
        SpringApplication.run(AppEureka.class,args);
    }
}
