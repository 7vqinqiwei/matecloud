package #{groupId}.gateway.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import #{groupId}.core.cloud.props.MineRequestProperties;
import #{groupId}.core.cloud.props.MineApiProperties;

/**
 * 预请求配置
 *
 * @author #{version}
 */
@Configuration
@EnableConfigurationProperties({MineRequestProperties.class, MineApiProperties.class})
public class PreRequestConfig {
}
