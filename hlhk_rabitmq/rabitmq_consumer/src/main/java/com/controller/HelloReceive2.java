package com.controller;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**扇形交换机，消费者监听队列1*/
@Component
public class HelloReceive2 {
    @RabbitListener(queuesToDeclare = {@Queue("QueueB") })
    public void processC(String str) {
        System.out.println("扇形交换机消费监听队列1:"+str);
    }
}