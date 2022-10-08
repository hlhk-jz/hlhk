package com.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**主题交换机，创建队列，交换机，以及进行绑定
 * 此时就有了发送的 队列名称 和 设置的路由键 匹配的概念
 * 队列1和2分别绑定了不同的路由键，当发送消息的
 * 队列名称和路由键匹配才会发送对应的队列中
 * 补充：创建队列时，名称不一样即可，然后消费者
 *       消费不同的队列，至于交换机把消息发给哪个
 *       和队列名称没有关系，完全是看发送消息的
 */
@Configuration
public class SenderConf {

    //队列1
    @Bean(name="message")
    public Queue queueMessage() {
        return new Queue("TOPICQueue1");
    }

    //队列2
    @Bean(name="messages")
    public Queue queueMessages() {
        return new Queue("TOPICQueue2");
    }

    //创建主题交换机
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Constant.TOPIC_EXCHANGE);
    }

    /**将队列1绑定到交换机上并指定路由键，没有特殊符号，所以是完全匹配*/
    @Bean
    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    /**将队列2绑定到交换机上并指定路由键*/
    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
    }
}