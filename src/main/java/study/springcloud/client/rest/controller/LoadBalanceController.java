package study.springcloud.client.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoadBalanceController {

    private String serviceId = "study-springcloud-provider";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping("/loadBalancer")
    public String getServerInfo() {
        ServiceInstance instance = loadBalancerClient.choose(serviceId);
        log.info("{}", instance);
        return "咔咔咔咔咔咔扩扩扩扩";
    }
}
