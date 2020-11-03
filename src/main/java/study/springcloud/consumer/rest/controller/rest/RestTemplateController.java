package study.springcloud.consumer.rest.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import study.springcloud.consumer.rest.support.Results;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 1.使用注解 @LoadBalanced 时，传给 RestTemplate 的url为服务名
     */
    @RequestMapping("/sayHi")
    public Map<String, Object> sayHi() {
        String url = "http://study-springcloud-provider/greeting/sayHi";
        String body = restTemplate.getForObject(url, String.class);
        log.info(">>>>>> {}", body);
        String name = restTemplate.getRequestFactory().getClass().getSimpleName();
        Map<String, Object> data = Results.data();
        data.put("requestFactory", name);
        return Results.ok(data);
    }

    /**
     * 1.不使用注解 @LoadBalanced 时，手动获取服务实例，再获取 host+port
     */
    @RequestMapping("/sayBye")
    public Map<String, Object> sayBye() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("study-springcloud-provider");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        StringBuffer sb = new StringBuffer("http://").append(host).append(":").append(port).append("/greeting/sayBye");
        String body = restTemplate.getForObject(sb.toString(), String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }
}
