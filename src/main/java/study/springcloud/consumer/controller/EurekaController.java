package study.springcloud.consumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eureka")
public class EurekaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaController.class);

    @Autowired
    private EurekaClient eurekaClient;

    @PostMapping("/getNextServer")
    public InstanceInfo getNextServer() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("study-springcloud-provider", false);
        LOGGER.info("===>{}", instanceInfo);
        return instanceInfo;
    }

    @PostMapping("/getInstances")
    public List<InstanceInfo> getInstances(String serviceId) {
        List<InstanceInfo> instanceInfoLt = eurekaClient.getInstancesById(serviceId);
        return instanceInfoLt;
    }
}
