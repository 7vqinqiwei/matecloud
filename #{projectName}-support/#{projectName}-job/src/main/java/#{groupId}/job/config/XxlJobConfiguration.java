package #{groupId}.job.config;

import com.xxl.job.core.executor.XxlJobExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时任务配置
 *
 * @author #{version}
 */
@Slf4j
@Configuration
@RefreshScope
public class XxlJobConfiguration {

	@Value("${#{projectName}.job.admin.addresses}")
	private String adminAddresses;

	@Value("${#{projectName}.job.executor.appname}")
	private String appname;

	@Value("${#{projectName}.job.executor.ip}")
	private String ip;

	@Value("${#{projectName}.job.executor.port}")
	private int port;

	@Value("${#{projectName}.job.accessToken}")
	private String accessToken;

	@Value("${#{projectName}.job.executor.logpath}")
	private String logPath;

	@Value("${#{projectName}.job.executor.logretentiondays}")
	private int logRetentionDays;


	@Bean(initMethod = "start", destroyMethod = "destroy")
	public XxlJobExecutor xxlJobExecutor() {
		log.info(">>>>>>>>>>> xxl-job config init.");
		XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();
		xxlJobExecutor.setAdminAddresses(adminAddresses);
		xxlJobExecutor.setAppname(appname);
		xxlJobExecutor.setIp(ip);
		xxlJobExecutor.setPort(port);
		xxlJobExecutor.setAccessToken(accessToken);
		xxlJobExecutor.setLogPath(logPath);
		xxlJobExecutor.setLogRetentionDays(logRetentionDays);

		return xxlJobExecutor;
	}

}
