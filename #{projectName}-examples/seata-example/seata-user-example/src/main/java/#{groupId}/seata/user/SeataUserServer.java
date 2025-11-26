package #{groupId}.seata.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import #{groupId}.core.feign.annotation.EnableMineFeign;

/**
 * Seata用户启动类
 *
 * @author #{version}
 */
@EnableMineFeign
@SpringBootApplication
@EnableTransactionManagement
public class SeataUserServer {
	public static void main(String[] args) {
		SpringApplication.run(SeataUserServer.class, args);
	}
}
