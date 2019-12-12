package study.springcloud.client.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TimeoutController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/await")
    public String await() {
        String str = restTemplate.postForObject("http://study-springcloud-provider/await", null, String.class);
        return str;
    }
}
