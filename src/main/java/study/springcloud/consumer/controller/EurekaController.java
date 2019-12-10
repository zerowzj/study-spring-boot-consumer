package study.springcloud.consumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/eureka")
public class EurekaController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private EurekaClient eurekaClient;

    @PostMapping("")
    public void demo() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("", false);
    }
}
