package #{groupId}.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * xxl-job启动器
 *
 * @author #{version}
 * @link https://gitee.com/xuxueli0323/xxl-job
 */
@SpringBootApplication
public class JobServer {
	public static void main(String[] args) {
		SpringApplication.run(JobServer.class, args);
	}
}
