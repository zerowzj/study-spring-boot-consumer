package study.springcloud.consumer.rest.support.ribbon;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RibbonClient(name = "study-springcloud-provider")
public class RibbonCfg {

//    @Bean
//    public IRule ribbonRule() {
//        IRule rule = new RoundRobinRule();
////        IRule rule = new RandomRule();
//        return rule;
//    }


//    @Bean
//    public IPing ribbonPing() {
//        IPing ping = new NoOpPing();
//        return ping;
//    }

//    @Bean
//    public ServerList<Server> ribbonServerList() {
//        return new ConfigurationBasedServerList();
//    }

//    @Bean
//    public ServerListSubsetFilter serverListFilter() {
//        ServerListSubsetFilter filter = new ServerListSubsetFilter();
//        return filter;
//    }
}
