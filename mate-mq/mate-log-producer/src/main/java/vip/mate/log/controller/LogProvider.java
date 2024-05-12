package vip.mate.log.controller;

import com.wayne.mq.kafka.starter.constant.LogConstant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

/**
 * @author xuzhanfu
 */
@Slf4j
@RestController
@AllArgsConstructor
public class LogProvider {

    private final StreamBridge streamBridge;

    @GetMapping("/sendMessageStr")
    public boolean sendMessage(String message) {
        return streamBridge.send(LogConstant.LOG_OUTPUT, message);
    }

    @Bean
    public Consumer<String> log() {
        return message -> {
            log.info("接收的普通消息为：{}", message);
        };
    }

}
