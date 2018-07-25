package com.rabbit.mq.producer;

import com.rabbit.mq.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiao
 * Date: 2018-07-25
 * Time: 15:13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DelayProducerTest {

    @Autowired
    private DelayProducer delayProducer;

    @Test
    public void produceMsg() {
        for (int i = 100; i >= 0; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("hello" + i);
            delayProducer.produceMsg(user);
        }
    }
}