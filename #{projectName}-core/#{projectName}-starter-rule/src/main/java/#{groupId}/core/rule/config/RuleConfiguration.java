package #{groupId}.core.rule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import #{groupId}.core.rule.service.IRuleCacheService;
import #{groupId}.core.rule.service.impl.RuleCacheServiceImpl;

/**
 * 规则配置
 * @author #{version}
 */
@Configuration
public class RuleConfiguration {

    @Bean
    public IRuleCacheService ruleCacheService() {
        return new RuleCacheServiceImpl();
    }
}
