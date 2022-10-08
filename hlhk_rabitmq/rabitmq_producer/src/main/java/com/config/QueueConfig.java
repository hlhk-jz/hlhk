package com.config;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**默认直连交换机 所以只创建队列即可
 *
 * */
@Configuration
public class QueueConfig {
    @Bean
    public Queue queue() {
        /**
         * 没有配置交换机，默认使用的直连交换机，
         * 直接往该队列发送数据即可
         * 此时的队列名称 也就是 routingKey(路由键)
         */
        return new Queue("DirectQueue");
    }
}