package study.springcloud.consumer.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import study.springcloud.consumer.rest.support.Results;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/retry")
public class RetryController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/timeout_get")
    public Map<String, Object> timeout_get(@RequestParam Long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Map<String, Object> data = Results.data();
        data.put("timeout", String.format("%s ms", timeout));
        return Results.ok(data);
    }

    @PostMapping("/timeout_post")
    public Map<String, Object> timeout_post(@RequestParam Long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Map<String, Object> data = Results.data();
        data.put("timeout", String.format("%s ms", timeout));
        return Results.ok(data);
    }

    @PostMapping("/timeout_idempotent")
    public Map<String, Object> timeout_idempotent
            (Long timeout, String orderNo) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        log.info("create order: [{}]", orderNo);
        return Results.ok();
    }

    //    @Retryable(maxAttempts = 6)
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
