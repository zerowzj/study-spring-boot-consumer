package study.springcloud.client.rest.support.rest;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateCfg {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        //全局连接和读取超时
//        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//        requestFactory.setReadTimeout(5 * 1000);
//        requestFactory.setConnectTimeout(5 * 1000);
//        RestTemplate restTemplate = new RestTemplate(requestFactory);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
