package com.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**延时队列实现，消费死信队列*/
@Component
@Slf4j
public class DelayedConsumer2 {
    @RabbitListener(queuesToDeclare = {@Queue("lind.queue.dead") })
    public void processC(String str) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        log.info("==== 消费死信队列:{},当前时间：{}",str,format);
    }
}
