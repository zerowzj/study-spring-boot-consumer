package study.springcloud.consumer.rest.controller.timeout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        String url = "http://study-springcloud-provider/timeoutByGet?timeout=" + timeout;
        String body = restTemplate.getForObject(url, String.class);
        log.info(">>>>>> {}", body);
        return Results.ok();
    }
}
