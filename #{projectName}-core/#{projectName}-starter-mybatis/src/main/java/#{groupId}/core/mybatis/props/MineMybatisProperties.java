
package #{groupId}.core.mybatis.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 日志打印配置
 *
 * @author L.cm #{version}
 */
@Getter
@Setter
@RefreshScope
@ConfigurationProperties("#{projectName}mybatis")
public class MineMybatisProperties {
	/**
	 * 是否打印可执行 sql
	 */
	private boolean sql = true;
}
