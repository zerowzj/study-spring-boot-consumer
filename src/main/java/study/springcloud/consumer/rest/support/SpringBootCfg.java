package study.springcloud.consumer.rest.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//服务注册和发现
@EnableEurekaClient
@EnableDiscoveryClient
//
@SpringBootApplication(scanBasePackages = "study.springcloud.consumer.rest")
public class SpringBootCfg {
}
