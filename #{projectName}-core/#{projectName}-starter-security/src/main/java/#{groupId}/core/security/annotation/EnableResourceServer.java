package #{groupId}.core.security.annotation;

import org.springframework.context.annotation.Import;
import #{groupId}.core.security.config.MineResourceServerConfig;

import java.lang.annotation.*;

/**
 * 资源服务注解
 *
 * @author #{version}
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MineResourceServerConfig.class)
public @interface EnableResourceServer {
}
