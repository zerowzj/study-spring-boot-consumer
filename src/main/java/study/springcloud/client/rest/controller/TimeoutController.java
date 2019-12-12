package study.springcloud.client.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TimeoutController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/timeout")
    public String timeout(@RequestParam Long timeout) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("timeout", timeout);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(param, headers);
        String str = restTemplate.postForObject("http://study-springcloud-provider/await", request, String.class);
        return str;
    }
}
