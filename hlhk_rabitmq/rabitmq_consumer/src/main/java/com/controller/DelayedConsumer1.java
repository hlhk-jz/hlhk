package com.controller;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**延时队列实现，消费普通队列 */
@Component
public class DelayedConsumer1 {
    //延时队列最好不设置消费者自动创建，否则如果忘记先创建延时队列了，就会创建普通没ttl的队列了
    //@RabbitListener(queuesToDeclare = {@Queue("lind.queue") })
    @RabbitListener(queues = "lind.queue")
    public void processC(String str) {
        System.out.println(">>>>>>> 消费普通队列:"+str);
    }
}
