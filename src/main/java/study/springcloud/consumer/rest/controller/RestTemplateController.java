package study.springcloud.consumer.rest.controller;

import com.google.common.collect.Maps;
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

    @RequestMapping("/requestFactory")
    public Map<String, Object> requestFactory() {
        Map<String, Object> data = Maps.newHashMap();
        String name = restTemplate.getRequestFactory().getClass().getName();
        data.put("name", name);
        return Results.ok(data);
    }

    @RequestMapping("/sayHi")
    public Map<String, Object> sayHi() {
        String body = restTemplate.getForObject("http://study-springcloud-provider/greeting/sayHi", String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }

    @RequestMapping("/sayBye")
    public Map<String, Object> sayBye() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("study-springcloud-provider");
        StringBuffer sb = new StringBuffer("http://")
                .append(serviceInstance.getHost())
                .append(":")
                .append(serviceInstance.getPort()).append("/greeting/sayBye");
        String body = restTemplate.getForObject(sb.toString(), String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }
}
