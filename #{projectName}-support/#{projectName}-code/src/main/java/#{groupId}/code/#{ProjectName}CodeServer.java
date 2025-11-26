package #{groupId}.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import #{groupId}.core.feign.annotation.EnableMineFeign;

/**
 * 代码生成启动类
 *
 * @author xuzhanfu
 * @date 2019-10-09 15:06
 **/
@EnableMineFeign
@SpringBootApplication
public class #{ProjectName}CodeServer {
    public static void main(String[] args) {
        SpringApplication.run(#{ProjectName}CodeServer.class, args);
    }
}
