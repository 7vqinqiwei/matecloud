package #{groupId}.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import #{groupId}.core.feign.annotation.EnableMineFeign;

/**
 * 系统组件启动类
 * @author #{version}
 */
@EnableMineFeign
@SpringBootApplication
public class ComponentServer {
    public static void main(String[] args) {
        SpringApplication.run(ComponentServer.class, args);
    }
}
