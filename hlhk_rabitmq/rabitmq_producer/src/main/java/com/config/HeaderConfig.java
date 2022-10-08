package com.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**头交换机*/
@Configuration
public class HeaderConfig {

    //队列1
    @Bean(name="headerQueue1")
    public Queue queueMessage() {
        return new Queue("headerQueue1");
    }

    //队列2
    @Bean(name="headerQueue2")
    public Queue queueMessages() {
        return new Queue("headerQueue2");
    }

    //交换机名称
    @Bean
    public HeadersExchange headersExchange(){
        return new HeadersExchange(Constant.HEADERS_EXCHANGE);
    }

    //队列1绑定到交换机
    @Bean
    Binding bindingExchangeMessage1(@Qualifier("headerQueue1") Queue queueMessage, HeadersExchange exchange) {
        Map<String, Object> map = new HashMap<>();
        map.put("age","23" );
        map.put("name","wangwu" );
        /**
         * x-match = any 发送的headers中有一组数据对应这
         * 里设置的数据即可发送到该队列
         * =all 发送的数据必须全部等于这里设置的key value才会发送
         */
        map.put("x-match", "any");
        return BindingBuilder.bind(queueMessage).to(exchange).whereAll(map).match();
    }

    //队列2绑定到交换机
    @Bean
    Binding bindingExchangeMessage2(@Qualifier("headerQueue2") Queue queueMessage, HeadersExchange exchange) {
        //场景1 消息头中有age字段就会进入到 headerQueue2 队列中
        //return BindingBuilder.bind(queueMessage).to(exchange).where("age").exists();
        //场景2 消息头中有age字段，并且字段值为23才会进入 headerQueue2 队列中
        return BindingBuilder.bind(queueMessage).to(exchange).where("age").matches("23");
    }
}
