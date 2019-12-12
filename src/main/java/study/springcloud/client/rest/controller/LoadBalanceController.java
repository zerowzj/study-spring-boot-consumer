package study.springcloud.client.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadBalanceController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/getServerInfo")
    public String getServerInfo() {
        String str = restTemplate.postForObject("http://study-springcloud-provider/getServerInfo", null, String.class);
        return str;
    }
}
