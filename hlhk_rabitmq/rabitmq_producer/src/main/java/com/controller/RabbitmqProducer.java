package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.config.Constant;
import com.config.HeaderConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class RabbitmqProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public void send(@RequestBody JSONObject object){
        log.info("发送数据："+object );

        //默认使用的是 直连交换机，所以没有指定交换机
       // rabbitTemplate.convertAndSend(object.get("queue")+"",JSON.toJSONString(object.get("value")));

        //发送指定交换机,该交换机在启动项目时需要创建(SenderConf中已创建)
       // rabbitTemplate.convertAndSend(Constant.TOPIC_EXCHANGE,object.get("queue")+"",JSON.toJSONString(object.get("value")));

        /**
         * 扇形交换机,没有路由键的概念，直接往交换机上发送，绑
         * 定了该交换机的队列都会收到该消息，routingKey设置空即可，
         * 因为设置别的也不生效
         */
       // rabbitTemplate.convertAndSend(Constant.FANOUT_EXCHANGE,"",JSON.toJSONString(object.get("value")));

        //头交换机
       /* Map objs = (Map)object.get("headers");
        Message msg01 = MessageBuilder.withBody(JSON.toJSONString(object.get("value")).getBytes()).setHeader(objs.get("key")+"",objs.get("value")).build();
        rabbitTemplate.send(Constant.HEADERS_EXCHANGE,null, msg01);*/

        /**
         * 死信队列测试，往普通队列发送，消息过期后会发送到创建
         * 的死信交换机，然后在发送到配置的队列上
         * 这里用的是 主题交换机
         */
        rabbitTemplate.convertAndSend(Constant.LIND_EXCHANGE,object.get("queue")+"",JSON.toJSONString(object.get("value")));
    }
}
