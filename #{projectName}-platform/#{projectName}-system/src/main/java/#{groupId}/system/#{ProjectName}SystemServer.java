package #{groupId}.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import #{groupId}.core.feign.annotation.EnableMineFeign;

/**
 * 管理系统后台启动类
 * @author xzf
 */
@EnableMineFeign
@SpringBootApplication
public class #{ProjectName}SystemServer {
    public static void main(String[] args) {
        SpringApplication.run(#{ProjectName}SystemServer.class, args);
    }
}
