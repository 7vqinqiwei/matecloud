package #{groupId}.core.log.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import #{groupId}.core.common.api.Result;
import #{groupId}.core.common.constant.ProviderConstant;
import #{groupId}.core.common.dto.CommonLog;
import #{groupId}.core.feign.constant.FeignConstant;

/**
 * feign调用#{projectName}-system存储日志
 * @author #{version}
 * @date 2020-7-1
 */
@FeignClient(value = FeignConstant.CLOUD_SYSTEM)
public interface ISysLogProvider {

    /**
     * 日志设置
     * @param commonLog　CommonLog对象
     * @return Result
     */
    @PostMapping(ProviderConstant.PROVIDER_LOG_SET)
    Result<Boolean> set(@RequestBody CommonLog commonLog);

}
