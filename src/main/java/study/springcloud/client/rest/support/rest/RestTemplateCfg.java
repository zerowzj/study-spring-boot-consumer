package study.springcloud.client.rest.support.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Slf4j
@Configuration
public class RestTemplateCfg {

    private static final int DEFAULT_CONNECTION_TIMEOUT = 5 * 1000;

    private static final int DEFAULT_READ_TIMEOUT = 5 * 1000;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.setConnectTimeout(Duration.ofSeconds(7))
                .setReadTimeout(Duration.ofSeconds(7))
                .build();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    public RestTemplate restTemplateByHttpCom1ponents() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(DEFAULT_CONNECTION_TIMEOUT);
        factory.setConnectTimeout(DEFAULT_READ_TIMEOUT);
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }

    public RestTemplate restTemplateByHttpComponents() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(DEFAULT_CONNECTION_TIMEOUT);
        factory.setConnectTimeout(DEFAULT_READ_TIMEOUT);
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }

    public RestTemplate restTemplateByOkHttp3() {
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();
        factory.setReadTimeout(DEFAULT_CONNECTION_TIMEOUT);
        factory.setConnectTimeout(DEFAULT_READ_TIMEOUT);
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }
}
