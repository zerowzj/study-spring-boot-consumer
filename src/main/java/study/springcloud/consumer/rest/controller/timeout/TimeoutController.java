package study.springcloud.consumer.rest.controller.timeout;

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
public class TimeoutController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/timeout")
    public Map<String, Object> timeout(@RequestParam Long timeout) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("timeout", timeout);
        String body = restTemplate.getForObject("http://study-springcloud-provider/timeout?timeout="+timeout, String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }
}
