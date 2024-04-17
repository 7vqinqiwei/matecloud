package vip.mate.core.security.annotation;

import org.springframework.context.annotation.Import;
import vip.mate.core.security.config.MateResourceServerConfig;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 资源服务注解
 *
 * @author pangu
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MateResourceServerConfig.class)
public @interface EnableMateResourceServer {
}
