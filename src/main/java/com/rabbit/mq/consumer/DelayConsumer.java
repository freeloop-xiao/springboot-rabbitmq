package com.rabbit.mq.consumer;

import com.rabbit.mq.config.QueueConfig;
import com.rabbit.mq.vo.User;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 * Description:延迟任务队列监听，手动确认消息
 * User: xiao
 * Date: 2018-07-25
 * Time: 15:10
 */
@Component
public class DelayConsumer {

    private Logger log = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = {QueueConfig.REGISTER_QUEUE_NAME})
    public void listenerDelayQueue(User user, Message message, Channel channel) {
        log.info("[listenerDelayQueue 监听的消息] - [消费时间] - [{}] - [{}]", LocalDateTime.now(), user.toString());
        try {
            // TODO 通知 MQ 消息已被成功消费,可以ACK了
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            // TODO 如果报错了,那么我们可以进行容错处理,比如转移当前消息进入其它队列
        }
    }
}
