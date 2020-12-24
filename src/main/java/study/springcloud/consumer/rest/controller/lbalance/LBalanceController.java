package study.springcloud.consumer.rest.controller.lbalance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import study.springcloud.consumer.rest.support.utils.Results;

import java.util.Map;

@Slf4j
@RestController
public class LBalanceController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getServerInfo")
    public Map<String, Object> getServerInfo() {
        String url = "http://study-springcloud-provider/getServerInfo";
        Map<String, Object> data = restTemplate.getForObject(url, Map.class);
        log.info(">>>>>> {}", data);
        return Results.ok(data);
    }
}
