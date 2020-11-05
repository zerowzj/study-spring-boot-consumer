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

    @RequestMapping("/requestFactory")
    public Map<String, Object> client() {
        String name = restTemplate.getRequestFactory().getClass().getSimpleName();
        Map<String, Object> data = Results.data();
        data.put("requestFactory", name);
        return Results.ok(data);
    }

    /**
     * 使用注解 @LoadBalanced 时，传给 RestTemplate 的url为服务名
     */
    @RequestMapping("/callByLB")
    public Map<String, Object> callByLoadBalanced() {
        String url = "http://study-springcloud-provider/sayHi";
        String body = restTemplate.getForObject(url, String.class);
        Map<String, Object> data = Results.data();
        data.put("msg", body);
        return Results.ok(data);
    }

    /**
     * 不使用注解 @LoadBalanced 时，手动获取服务实例，再获取 host+port
     */
    @RequestMapping("/callByGet")
    public Map<String, Object> call() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("study-springcloud-provider");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        StringBuffer sb = new StringBuffer("http://").append(host).append(":").append(port).append("/sayHi");
        String body = restTemplate.getForObject(sb.toString(), String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }
}
