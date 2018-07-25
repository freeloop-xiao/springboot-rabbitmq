package com.rabbit.mq.producer;

import com.rabbit.mq.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiao
 * Date: 2018-07-12
 * Time: 09:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {


    @Autowired
    private Producer producer;

    @Test
    public void produceMsg() throws Exception{

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("hello" + i);
            producer.produceMsg(user);
        }
        Thread.sleep(1000000);
    }
}