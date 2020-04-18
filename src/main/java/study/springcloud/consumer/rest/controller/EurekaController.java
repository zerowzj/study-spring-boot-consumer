package study.springcloud.consumer.rest.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/eureka")
public class EurekaController {


    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping("/getNextServer")
    public InstanceInfo getNextServer() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("study-springcloud-provider", false);
        log.info("===>{}", instanceInfo);
        return instanceInfo;
    }

    @PostMapping("/getInstances")
    public List<InstanceInfo> getInstances(String serviceId) {
        List<InstanceInfo> instanceInfoLt = eurekaClient.getInstancesById(serviceId);
        return instanceInfoLt;
    }
}
