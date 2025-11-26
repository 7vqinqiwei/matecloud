package #{groupId}.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import #{groupId}.core.feign.annotation.EnableMineFeign;

/**
 * 单点登录启动类
 *
 * @author #{version}
 */
@EnableMineFeign
@SpringBootApplication
public class SsoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SsoApplication.class, args);
	}
}
