package study.springcloud.client.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetryController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/404")
    public void retry404(@RequestParam Long timeout) {
        restTemplate.postForObject("http://study-springcloud-provider/404", null, Void.class);
    }

    @PostMapping("/500")
    public void retry500(@RequestParam Long timeout) {
        restTemplate.postForObject("http://study-springcloud-provider/500", null, Void.class);
    }
}
