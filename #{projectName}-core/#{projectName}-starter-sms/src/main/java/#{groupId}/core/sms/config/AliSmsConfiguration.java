package #{groupId}.core.sms.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import #{groupId}.core.sms.core.AliSmsTemplate;
import #{groupId}.core.sms.core.SmsTemplate;
import #{groupId}.core.sms.props.SmsProperties;

/**
 * 阿里短信配置
 *
 * @author #{version}
 */
@Configuration
@EnableConfigurationProperties(value = SmsProperties.class)
@ConditionalOnProperty(prefix = SmsProperties.PREFIX, name = "enable", havingValue = "true")
public class AliSmsConfiguration {

	@Bean
	public SmsTemplate aliSmsTemplate(SmsProperties smsProperties) {
		return new AliSmsTemplate(smsProperties);
	}
}
