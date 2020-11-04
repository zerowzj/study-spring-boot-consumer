package study.springcloud.consumer.rest.controller.retry;

import com.google.common.collect.Maps;
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

    @RequestMapping("/timeoutByGet")
    public Map<String, Object> timeoutByGet(@RequestParam long timeout) {
        String url = "http://study-springcloud-provider/timeoutByGet?timeout=" + timeout;
        String body = restTemplate.getForObject(url, String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }

    @RequestMapping("/timeoutByPost")
    public Map<String, Object> timeoutByPost(@RequestParam long timeout) {
        String url = "http://study-springcloud-provider/timeoutByPost?timeout=" + timeout;
        Map<String, Object> params = Maps.newHashMap();
        params.put("timeout", timeout);
        String body = restTemplate.postForObject(url, params, String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }

    @RequestMapping("/codeByGet")
    public Map<String, Object> codeByGet(@RequestParam int code) {
        String url = "http://study-springcloud-provider/retryByGet?code=" + code;
        String body = restTemplate.getForObject(url, String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }

    @RequestMapping("/codeByPost")
    public Map<String, Object> codeByPost(@RequestParam int code) {
        String url = "http://study-springcloud-provider/codeByPost?code=" + code;
        String body = restTemplate.getForObject(url, String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }
}
