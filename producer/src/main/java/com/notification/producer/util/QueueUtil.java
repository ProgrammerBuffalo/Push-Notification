package com.notification.producer.util;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QueueUtil {

    @Autowired
    private AmqpAdmin amqpAdmin;

    public Queue declareQueue(String userId) {
       Map<String, Object> queueArgs = new HashMap<>();

       queueArgs.put("x-expires", 60 * 30 * 1000);

       Queue queue = new Queue(String.format("queue-%s", userId), true, true, false);
       return queue;
    }

    public boolean deleteQueue(String userId) {
        return amqpAdmin.deleteQueue(String.format("queue-%s", userId));
    }
}
