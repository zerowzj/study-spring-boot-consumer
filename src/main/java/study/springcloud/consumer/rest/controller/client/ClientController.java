package study.springcloud.consumer.rest.controller.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import study.springcloud.consumer.rest.support.Results;

import java.util.Map;

@Slf4j
@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/client")
    public Map<String, Object> client() {
        String name = restTemplate.getRequestFactory().getClass().getSimpleName();
        Map<String, Object> data = Results.data();
        data.put("requestFactory", name);
        return Results.ok(data);
    }
}
