package com.qyf.maven_demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
   指定监听的exchange、queue，并绑定。
 * @author qyf
 *
 */
@Configuration
public class MqConfig {
    @Bean
    public Queue queue1() {
        return new Queue("topic.queue1");
    }


    @Bean
    public Queue queue2() {
        return new Queue("topic.queue2");
    }


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }


    @Bean
    public Binding bingingExchangeMessage1(Queue queue1, TopicExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange).with("topic.queue1");
    }


    @Bean
    public Binding bingingExchangeMessage2(Queue queue2, TopicExchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange).with("topic.#");
    }
}

/**
 * Exchange的四种类型:
 *   Direct Exchange:直接匹配,通过Exchange名称+RountingKey来发送与接收消息. 
 *   Fanout Exchange:广播订阅,向所有的消费者发布消息,但是只有消费者将队列绑定到该路由器才能收到消息,忽略Routing Key. 
 *   Topic Exchange：主题匹配订阅,这里的主题指的是RoutingKey,RoutingKey可以采用通配符,如:*或#，RoutingKey命名采用.来分隔多个词,只有消息这将队列绑定到该路由器且指定RoutingKey符合匹配规则时才能收到消息; 
 *   Headers Exchange:消息头订阅,消息发布前,为消息定义一个或多个键值对的消息头,然后消费者接收消息同时需要定义类似的键值对请求头:(如:x-mactch=all或者x_match=any)，只有请求头与消息头匹配,才能接收消息,忽略RoutingKey.
 *   
 */
