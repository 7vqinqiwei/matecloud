package #{groupId}.seata.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import #{groupId}.core.feign.annotation.EnableMineFeign;

/**
 * Seata订单启动类
 *
 * @author #{version}
 */
@EnableMineFeign
@SpringBootApplication
@EnableTransactionManagement
public class SeataOrderServer {
	public static void main(String[] args) {
		SpringApplication.run(SeataOrderServer.class, args);
	}
}
