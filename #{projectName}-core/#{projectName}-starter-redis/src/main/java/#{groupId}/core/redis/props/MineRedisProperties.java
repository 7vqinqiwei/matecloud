package #{groupId}.core.redis.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * redis配置
 *
 * @author #{version}
 */
@Getter
@Setter
@ConfigurationProperties(MineRedisProperties.PREFIX)
public class MineRedisProperties {
	/**
	 * 前缀
	 */
	public static final String PREFIX = "#{projectName}lettuce.redis";
	/**
	 * 是否开启Lettuce
	 */
	private Boolean enable = true;
}
