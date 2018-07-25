package com.rabbit.mq.consumer;

import com.rabbit.mq.vo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description: 普通队列监听
 * User: xiao
 * Date: 2018-07-12
 * Time: 09:06
 */
@Component
public class Consumer {

    @RabbitListener(queues= "dev.book.register.queue")
    public void recievedMessage(User msg) {
        System.out.println("========="+new Date()+"=======Recieved Message: " + msg);
    }


}
