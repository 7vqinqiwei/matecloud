package #{groupId}.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import #{groupId}.core.feign.annotation.EnableMineFeign;

/**
 * 日志消息生产者启动类
 * @author #{version}
 */
@EnableMineFeign
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class LogProducerServer {

    public static void main(String[] args) {
        SpringApplication.run(LogProducerServer.class, args);
    }

}
