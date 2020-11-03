package study.springcloud.consumer.rest.support.ribbon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RibbonCfg {

//    @Bean
//    public IRule ribbonRule() {
//        new RoundRobinRule(); //轮询
//        new RetryRule(); //
//        IRule rule = new RoundRobinRule();
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
