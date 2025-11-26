package #{groupId}.core.cloud.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import #{groupId}.core.cloud.filter.TraceFilter;
import #{groupId}.core.cloud.props.MineRequestProperties;

/**
 * 请求配置，包括tracId和其他网络请求
 * @author #{version}
 */
@Configuration
@EnableConfigurationProperties(MineRequestProperties.class)
public class RequestConfiguration {

//    @Bean
//    public TenantContextHolderFilter tenantContextHolderFilter() {
//        return new TenantContextHolderFilter();
//    }

    @Bean
    public TraceFilter traceFilter() {
        return new TraceFilter();
    }

}
