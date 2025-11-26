package #{groupId}.core.kafka.config;

import org.springframework.context.annotation.PropertySource;
import #{groupId}.core.common.factory.YamlPropertySourceFactory;

@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:#{projectName}-kafka.yml")
public class KafkaConfiguration {
}
