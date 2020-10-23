package study.springcloud.consumer.rest.controller;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/requestFactory")
    public Map<String, Object> requestFactory() {
        Map<String, Object> data = Maps.newHashMap();
        String name = restTemplate.getRequestFactory().getClass().getName();
        String simpleName = restTemplate.getRequestFactory().getClass().getSimpleName();
        data.put("name", name);
        data.put("simpleName", simpleName);
        return data;
    }
}
