package study.springcloud.consumer.rest.support.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Collections;

@Slf4j
@Configuration
public class RestTemplateCfg {

    @Bean
//    @LoadBalanced  //Ribbon负载均衡
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new CustomRequestInterceptor()));

        ClientHttpRequestFactory requestFactory = restTemplate.getRequestFactory();
        log.info(">>>>>> {}", requestFactory.getClass().getSimpleName());
        return restTemplate;
    }

//    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.setConnectTimeout(Duration.ofSeconds(7))
                .setReadTimeout(Duration.ofSeconds(7))
                .build();
        restTemplate.setInterceptors(Collections.singletonList(new CustomRequestInterceptor()));

        ClientHttpRequestFactory requestFactory = restTemplate.getRequestFactory();
        log.info(">>>>>> {}", requestFactory.getClass().getSimpleName());
        return restTemplate;
    }
}
