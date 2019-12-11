package study.springcloud.client.rest.support.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@RibbonClients(value = {
//        @RibbonClient(name = "study-springcloud-provider", configuration = RibbonCfg.class)
////        ,@RibbonClient(name = "study-springcloud-provider", configuration = RibbonCfg.class)
//})
public class RibbonCfg {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

    @Bean
    public IPing ribbonPing() {
//        return new PingUrl();
        return new NoOpPing();
    }

//    @Bean
//    public ServerList<Server> ribbonServerList() {
//        return new ConfigurationBasedServerList();
//    }

    @Bean
    public ServerListSubsetFilter serverListFilter() {
        ServerListSubsetFilter filter = new ServerListSubsetFilter();
        return filter;
    }
}
