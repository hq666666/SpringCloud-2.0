package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 搭建eureka集群：创建此服务
 */
@SpringBootApplication
@EnableEurekaServer  //开启注册中心
public class AppEureka02 {

    public static void main(String[] args) {
        SpringApplication.run(AppEureka02.class,args);
    }
}
