package com.controller;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**直连交换机，消费者2*/
@Component
public class HelloReceive {
    //Direct模式消费者2
    @RabbitListener(queuesToDeclare = {@Queue("DirectQueue") })    //监听器监听指定的Queue
    public void processC(String str) {
        System.out.println("Direct模式消费2:"+str);
    }
}