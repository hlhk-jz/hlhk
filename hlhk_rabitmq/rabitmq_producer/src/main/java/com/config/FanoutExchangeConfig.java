package com.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**扇形交换机
 * 绑定了该交换机的队列都会收到消息
 * */
@Configuration
public class FanoutExchangeConfig {
    /**队列1*/
    @Bean("QueueA")
    public Queue getQueueA(){
        return new Queue("QueueA");
    }
    /**队列2*/
    @Bean("QueueB")
    public Queue getQueueB(){
        return new Queue("QueueB");
    }

    /**创建扇形交换机*/
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(Constant.FANOUT_EXCHANGE);
    }

    /**队列1绑定交换机*/
    @Bean
    Binding bindingExchangeA(@Qualifier("QueueA") Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
    /**队列2绑定交换机*/
    @Bean
    Binding bindingExchangeB(@Qualifier("QueueB") Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
}
