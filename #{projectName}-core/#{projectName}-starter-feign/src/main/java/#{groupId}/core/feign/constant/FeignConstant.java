package #{groupId}.core.feign.constant;

import lombok.experimental.UtilityClass;

/**
 * Feign常量类
 * @author xuzhanfu
 * @Date 2020-7-1
 */
@UtilityClass
public class FeignConstant {

    /**
     * 网关
     */
    public final String CLOUD_GATEWAY = "#{projectName}-gateway";

    /**
     * 系统服务
     */
    public final String CLOUD_SYSTEM = "#{projectName}-system";

    /**
     * 认证服务
     */
    public final String CLOUD_UAA = "#{projectName}-uaa";

    /**
     * 消息生产者
     */
    public final String CLOUD_LOG_PRODUCER = "#{projectName}-log-producer";
}
