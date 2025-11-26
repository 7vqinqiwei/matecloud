package #{groupId}.core.log.event;

import org.springframework.context.ApplicationEvent;
import #{groupId}.core.common.dto.CommonLog;

/**
 * 日志事件
 * @author #{version} 
 * @since 2020-7-15
 */
public class LogEvent extends ApplicationEvent {

    public LogEvent(CommonLog source) {
        super(source);
    }
}
