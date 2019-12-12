package study.springcloud.client.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.retry.annotation.Retryable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetryController {

    @Autowired
    private RestTemplate restTemplate;

    @Retryable
    @PostMapping("/retry")
    public void retry(@RequestParam int code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("code", code);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(param, headers);
        restTemplate.postForObject("http://study-springcloud-provider/retry", request, Void.class);
    }
}
