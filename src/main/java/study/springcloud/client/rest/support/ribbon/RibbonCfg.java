package study.springcloud.client.rest.support.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClients(value = {
        @RibbonClient(name = "study-springcloud-provider", configuration = RibbonCfg.class),
        @RibbonClient(name = "study-springcloud-provider", configuration = RibbonCfg.class)
})
public class RibbonCfg {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
