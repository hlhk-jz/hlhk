package com.controller;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**头交换机队列1消费者*/
@Component
public class HeadersConsumer1 {
    @RabbitListener(queuesToDeclare = {@Queue("headerQueue1") })
    public void processC(byte[] msg) {
        System.out.println("头交换机队列1消费者:"+new String(msg));
    }
}