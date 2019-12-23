package study.springcloud.client.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateController.class);

    String url;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping("/demo")
    public String demo() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("study-springcloud-provider");
        String str = restTemplate.postForObject("http://study-springcloud-provider/getServerInfo", null, String.class);
        return str;
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
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //参数
        Object request = null;
        Class<String> responseType = String.class;
        Object[] uriVariables = null;
        //
        String response1 = restTemplate.postForObject(url, request, responseType);
        String response2 = restTemplate.postForObject(url, request, responseType, uriVariables);
        return null;
    }

    @PostMapping("/getForEntity")
    public String getForEntity() {
        //参数
        Class<String> responseType = String.class;
        Object[] uriVariables = null;
        //
        ResponseEntity<String> response1 = restTemplate.getForEntity(url, responseType);
        ResponseEntity<String> response2 = restTemplate.getForEntity(url, responseType, uriVariables);
        return null;
    }

    @PostMapping("/getForObject")
    public String getForObject() {
        //参数
        Class<String> responseType = String.class;
        Object[] uriVariables = null;
        //
        String response1 = restTemplate.getForObject(url, responseType);
        String response2 = restTemplate.getForObject(url, responseType, uriVariables);
        return null;
    }
}
