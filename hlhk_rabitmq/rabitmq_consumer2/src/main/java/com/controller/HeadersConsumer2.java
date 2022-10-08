package com.controller;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**头交换机队列2消费者*/
@Component
public class HeadersConsumer2 {
    @RabbitListener(queuesToDeclare = {@Queue("headerQueue2") })
    public void processC(byte[] msg) {
        System.out.println("头交换机队列2消费者:"+new String(msg));
    }
}