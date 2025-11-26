package #{groupId}.seata.point;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import #{groupId}.core.feign.annotation.EnableMineFeign;

/**
 * Seata积分启动类
 * @author #{version}
 */
@EnableMineFeign
@SpringBootApplication
@EnableTransactionManagement
public class SeataPointServer {
	public static void main(String[] args) {
		SpringApplication.run(SeataPointServer.class, args);
	}
}
