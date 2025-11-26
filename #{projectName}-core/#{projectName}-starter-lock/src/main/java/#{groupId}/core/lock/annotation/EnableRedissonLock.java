package #{groupId}.core.lock.annotation;

import org.springframework.context.annotation.Import;
import #{groupId}.core.lock.config.RedissonConfiguration;

import java.lang.annotation.*;

/**
 * 开启Redisson注解支持
 *
 * @author #{version}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@Import(RedissonConfiguration.class)
public @interface EnableRedissonLock {
}
