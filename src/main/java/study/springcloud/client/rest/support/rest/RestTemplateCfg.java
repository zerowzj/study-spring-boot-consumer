package study.springcloud.client.rest.support.rest;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateCfg {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
//        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//        requestFactory.setReadTimeout(5 * 1000);
//        requestFactory.setConnectTimeout(5 * 1000);
//        RestTemplate restTemplate = new RestTemplate(requestFactory);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
