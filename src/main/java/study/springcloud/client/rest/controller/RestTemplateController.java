package study.springcloud.client.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateController.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping("/demo")
    public String demo() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("study-springcloud-provider");
        String str = restTemplate.postForObject("http://study-springcloud-provider/getServerInfo", null, String.class);
        return str;
    }
}
