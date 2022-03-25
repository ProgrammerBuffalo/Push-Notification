package com.notification.producer.configuration;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("users-exchange");
    }

}
