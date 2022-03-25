package com.notification.producer.service;

import com.notification.producer.exception.NotFoundException;
import com.notification.producer.model.Message;
import com.notification.producer.model.entity.User;
import com.notification.producer.util.QueueUtil;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanoutExchange;

    @Autowired
    private UserService userService;

    @Autowired
    private QueueUtil queueUtil;

    public void attachUser(String userId) throws NotFoundException {
        User user = userService.find(userId);

        Queue queue = queueUtil.declareQueue(user.getId());

        BindingBuilder.bind(queue).to(fanoutExchange);
    }

    public boolean detachUser(String userId) throws NotFoundException {
        User user = userService.find(userId);

        return queueUtil.deleteQueue(userId);
    }

    public void notify(Message<?> message) {
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), message.getData());
    }

}
