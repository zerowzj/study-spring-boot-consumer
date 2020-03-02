package study.springcloud.client.rest.controller;

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

//    @PostMapping("/postForEntity")
//    public String postForEntity() {
//        HttpHeaders headers = new HttpHeaders();
//        //
//        Object request = null;
//        Class<String> responseType = String.class;
//        Object[] uriVariables = null;
//        //
//        ResponseEntity<String> response1 = restTemplate.postForEntity(url, request, responseType);
//        ResponseEntity<String> response2 = restTemplate.postForEntity(url, request, responseType, uriVariables);
//        return null;
//    }

//    @PostMapping("/postForObject")
//    public String postForObject() {
//        //参数
//
//        Class<String> responseType = String.class;
//        Object[] uriVariables = null;
//        //
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(param, headers);
//        //
//        String response1 = restTemplate.postForObject(url, request, responseType);
//        return null;
//    }

//    @PostMapping("/getForEntity")
//    public String getForEntity() {
//        //参数
//        Class<String> responseType = String.class;
//        Object[] uriVariables = null;
//        //
//        ResponseEntity<String> response1 = restTemplate.getForEntity(url, responseType);
//        ResponseEntity<String> response2 = restTemplate.getForEntity(url, responseType, uriVariables);
//        return null;
//    }

//    @PostMapping("/getForObject")
//    public String getForObject() {
//        //参数
//        Class<String> responseType = String.class;
//        Object[] uriVariables = null;
//        //
//        String response1 = restTemplate.getForObject(url, responseType);
//        String response2 = restTemplate.getForObject(url, responseType, uriVariables);
//        return null;
//    }
}
