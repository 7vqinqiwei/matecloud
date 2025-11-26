package #{groupId}.system.feign;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import #{groupId}.core.common.api.Result;
import #{groupId}.core.common.constant.ProviderConstant;
import #{groupId}.core.common.dto.CommonLog;
import #{groupId}.core.log.feign.ISysLogProvider;
import #{groupId}.system.entity.SysLog;
import #{groupId}.system.service.ISysLogService;

/**
 * 日志远程调用
 * @author #{version}
 */
@Slf4j
@RestController
@AllArgsConstructor
@Api(tags = "日志远程调用")
public class SysLogProvider implements ISysLogProvider {

    private final ISysLogService sysLogService;

    @Override
    @PostMapping(ProviderConstant.PROVIDER_LOG_SET)
    @ApiOperation(value = "日志设置", notes = "日志设置")
    public Result<Boolean> set(CommonLog commonLog) {
        SysLog sysLog = new SysLog();
        BeanUtils.copyProperties(commonLog, sysLog);
        return Result.data(sysLogService.save(sysLog));
    }
}
