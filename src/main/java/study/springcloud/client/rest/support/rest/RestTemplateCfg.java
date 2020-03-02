package study.springcloud.client.rest.support.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Slf4j
@Configuration
public class RestTemplateCfg {

    private static final int DEFAULT_CONNECTION_TIMEOUT = 5 * 1000;

    private static final int DEFAULT_READ_TIMEOUT = 5 * 1000;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        RestTemplate restTemplate = builder.setConnectTimeout(Duration.ofSeconds(7))
//                .setReadTimeout(Duration.ofSeconds(7))
//                .build()
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new RestRequestInterceptor()));
        return restTemplate;
    }
}
