package com.controller;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**直连交换机，消费者1*/
@Component
public class HelloReceive {
    @RabbitListener(queuesToDeclare = {@Queue("DirectQueue") })    //监听器监听指定的Queue
    public void processC(String str) {
        System.out.println("Direct模式消费1:"+str);
    }
}