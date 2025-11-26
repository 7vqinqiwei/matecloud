package #{groupId}.uaa.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * social的配置参数
 * @author #{author}
 * @since {date}
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "social.vue")
public class SocialConfig {

    private String url;
}
