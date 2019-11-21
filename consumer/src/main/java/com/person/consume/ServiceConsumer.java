package com.person.consume;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ServiceConsumer {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumer.class,args);
    }

    /**
     *  01:找不到RestTemplate,将其注入搭配springboot容器 ;
     *  02:引入@LoadBalanced可以进行服务别名调用该服务；
     *  03：且RestTemplate具有负载均衡的能力；
     */
    @Bean
    //@LoadBalanced
    RestTemplate getInstance(){
        return  new RestTemplate();
    }
}
