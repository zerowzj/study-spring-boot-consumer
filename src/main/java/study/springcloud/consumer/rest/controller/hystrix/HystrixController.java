package study.springcloud.consumer.rest.controller.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import study.springcloud.consumer.rest.support.Results;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getError")
    @RequestMapping("/getServerInfo")
    public Map<String, Object> getServerInfo() {
        String url = "http://study-springcloud-provider/getServerInfo";
        Map<String, Object> data = restTemplate.getForObject(url, Map.class);
        log.info(">>>>>> {}", data);
        return Results.ok(data);
    }

    public String getError(String id) {
        System.out.println(Thread.currentThread().getName() + "断路器启动");
        return "断路器fallback返回error";
    }
}