package #{groupId}.core.lock.config.strategy;

import org.redisson.config.Config;
import #{groupId}.core.lock.props.RedissonProperties;

/**
 * Redisson配置构建接口
 *
 * @author #{version}
 */
public interface RedissonConfigStrategy {

	/**
	 * 根据不同的Redis配置策略创建对应的Config
	 *
	 * @param redissonProperties redisson配置
	 * @return Config
	 */
	Config createRedissonConfig(RedissonProperties redissonProperties);
}
