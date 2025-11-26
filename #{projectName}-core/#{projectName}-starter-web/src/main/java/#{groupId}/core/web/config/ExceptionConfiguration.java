package #{groupId}.core.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import #{groupId}.core.common.factory.YamlPropertySourceFactory;
import #{groupId}.core.web.handler.BaseExceptionHandler;

/**
 * 统一异常处理配置
 * @author xuzhanfu
 */
@Configuration
@ComponentScan(value="#{groupId}.core.web.handler")
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:#{projectName}-error.yml")
public class ExceptionConfiguration {

    @Bean
    public BaseExceptionHandler baseExceptionHandler(){
        return new BaseExceptionHandler();
    }
}
