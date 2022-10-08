package com.config;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 延时队列实现
 * 主要测试一个死信队列，功能主要实现延时消费，原理是先把消息发到正常队列，
 * 正常队列有超时时间，当达到时间后自动发到死信队列，然后由消费者去消费死信队列里的消息.
 */
@Configuration
public class DelayedConfig {

    public static final String LIND_DL_EXCHANGE = "lind.dl.exchange";
    public static final String LIND_QUEUE = "lind.queue";
    public static final String LIND_DEAD_QUEUE = "lind.queue.dead";

    /**
     * 单位为微秒.
     */
    @Value("${tq.makecall.expire:10000}")
    private long makeCallExpire;

    /**
     * 创建普通交换机. lind.exchange
     */
    @Bean
    public TopicExchange lindExchange() {
        return (TopicExchange) ExchangeBuilder.topicExchange(Constant.LIND_EXCHANGE).durable(true)
                .build();
    }

    /**
     * 创建普通队列. lind.queue
     */
    @Bean
    public Queue lindQueue() {
        return QueueBuilder.durable(LIND_QUEUE)
                .withArgument("x-dead-letter-exchange", LIND_DL_EXCHANGE)//设置死信交换机
                .withArgument("x-message-ttl", makeCallExpire)
                .withArgument("x-dead-letter-routing-key", LIND_DEAD_QUEUE)//设置死信队列
                .build();
    }
    /**
     * 绑定普通队列.
     *
     * @return
     */
    @Bean
    public Binding bindBuilders() {
        return BindingBuilder.bind(lindQueue())
                .to(lindExchange())
                .with(LIND_QUEUE);
    }

    /**
     * 创建死信队列.
     */
    @Bean
    public Queue lindDelayQueue() {
        return QueueBuilder.durable(LIND_DEAD_QUEUE).build();
    }

    /**
     * 创建死信交换机. lind.dl.exchange
     */
    @Bean
    public TopicExchange lindExchangeDl() {
        return (TopicExchange) ExchangeBuilder.topicExchange(LIND_DL_EXCHANGE).durable(true)
                .build();
    }

    /**
     * 绑定死信队列.
     */
    @Bean
    public Binding bindDeadBuilders() {
        return BindingBuilder.bind(lindDelayQueue())
                .to(lindExchangeDl())
                .with(LIND_DEAD_QUEUE);
    }

}
