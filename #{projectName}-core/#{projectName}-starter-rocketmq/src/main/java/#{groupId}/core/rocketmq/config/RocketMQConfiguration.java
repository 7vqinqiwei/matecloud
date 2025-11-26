package #{groupId}.core.rocketmq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import #{groupId}.core.common.factory.YamlPropertySourceFactory;

/**
 * RocketMQ配置
 *
 * @author #{version}
 */
@Configuration
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:#{projectName}-rocketmq.yml")
public class RocketMQConfiguration {
}
