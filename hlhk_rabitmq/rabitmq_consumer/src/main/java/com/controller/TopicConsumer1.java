package com.controller;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 主题交换机队列1消费者
 */
@Component
public class TopicConsumer1 {
    //主题交换机队列1消费者
    @RabbitListener(queuesToDeclare = {@Queue("TOPICQueue1") })
    public void processC(String str) {
        System.out.println("主题交换机队列1消费者:"+str);
    }

    //主题交换机队列2消费者
    @RabbitListener(queuesToDeclare = {@Queue("TOPICQueue2") })
    public void processB(String str) {
        System.out.println("主题交换机队列2消费者:"+str);
    }
}
