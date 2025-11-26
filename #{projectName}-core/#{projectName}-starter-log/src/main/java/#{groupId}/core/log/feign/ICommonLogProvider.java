package #{groupId}.core.log.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import #{groupId}.core.common.api.Result;
import #{groupId}.core.common.dto.CommonLog;
import #{groupId}.core.feign.constant.FeignConstant;

/**
 * 普通日志生产消息调用
 * @author #{version}
 */

@FeignClient(value = FeignConstant.CLOUD_LOG_PRODUCER)
public interface ICommonLogProvider {

    /**
     * 向消息中心发送消息
     * @param commonLog 普通日志
     * @return 状态
     */
    @PostMapping("/provider/common-log/send")
    Result<?> sendCommonLog(CommonLog commonLog);
}
