package study.springcloud.client.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/requestFactory")
    public String demo() {
        String name = restTemplate.getRequestFactory().getClass().getName();
        log.info("==========");
        log.info("{}", restTemplate.getRequestFactory().getClass().getSimpleName());
        log.info("==========");
        return name;
    }

    @PostMapping("/postForEntity")
    public String postForEntity() {
        HttpHeaders headers = new HttpHeaders();
        //
        Object request = null;
        Class<String> responseType = String.class;
        Object[] uriVariables = null;
        //
        ResponseEntity<String> response1 = restTemplate.postForEntity(url, request, responseType);
        ResponseEntity<String> response2 = restTemplate.postForEntity(url, request, responseType, uriVariables);
        return null;
    }

    @PostMapping("/postForObject")
    public String postForObject() {
        //参数

        Class<String> responseType = String.class;
        Object[] uriVariables = null;
        //
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(param, headers);
        //
        String response1 = restTemplate.postForObject(url, request, responseType);
        String response2 = restTemplate.postForObject(url, request, responseType, uriVariables);
        return null;
    }

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
