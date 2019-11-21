package com.person.consume.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author  hq
 * @date 2019/11/19
 * 消费客户端;
 */
@RestController
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient; //可以获取服务别名的eureka服务的信息
    //服务请求数
    private AtomicInteger reqcount = new AtomicInteger(1);
    /**
     * springCloud 调用服务的两种方式： rest 、feign
     *
     * @return
     */
    @RequestMapping("/consume")
    public String consume() {

        String url = "http://provider/provide";
            //通过直接的ip调用
        //String result = restTemplate.getForObject("http://127.0.0.1:8001/provide", String.class);
        /**
         * 通过该服务别名调用:
         *      出现异常：java.net.UnknownHostException: provider
         *      解决方案：
         *        01：由于RestTemplate依赖与Ribbon,所以要使用@loadBalance进行注入；
         *        02：好处：
         *            RestTemplate具有了客户端的负载均衡的能力；（注意：ribbon属于本地负载均衡，不是想nginx那样可以服务器之间的调用）；
         */
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
    /**
     * 手写本地负载均衡：
     *
     * @return
     */
    @RequestMapping("/toconsume")
    public String toConsume() {
       String instance =  getInstance();
        String url = instance+"/provide";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    /**
     * 负载均衡的小案例
     * @return
     */
    private String getInstance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
        if(null == instances || instances.size() <= 0){
            return  "";
        }
        //传统负载均衡的算法：取模算法
        int index = reqcount.intValue() % instances.size();
        reqcount.incrementAndGet();
        return instances.get(index).getUri().toString();
    }

}