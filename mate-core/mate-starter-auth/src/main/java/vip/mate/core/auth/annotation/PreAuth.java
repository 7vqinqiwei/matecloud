package vip.mate.core.auth.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * URL权限注解
 *
 * @author pangu
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PreAuth {

    /**
     * 是否启用
     *
     * @return boolean
     */
    boolean enabled() default true;

    /**
     * 验证用户是否授权
     *
     * @return String
     */
    String hasPerm() default "";
}
