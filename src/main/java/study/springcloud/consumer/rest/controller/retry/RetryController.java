package study.springcloud.consumer.rest.controller.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import study.springcloud.consumer.rest.support.Results;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/retry")
public class RetryController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/timeout")
    public Map<String, Object> timeout(@RequestParam long timeout) {
        String url = "http://study-springcloud-provider/timeout?timeout=" + timeout;
        String body = restTemplate.getForObject(url, String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }

    @PostMapping("/code")
    public Map<String, Object> code(@RequestParam int code) {
        String url = "http://study-springcloud-provider/retry?code=" + code;
        String body = restTemplate.getForObject(url, String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }
}
