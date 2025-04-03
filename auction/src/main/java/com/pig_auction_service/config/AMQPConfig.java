package com.pig_auction_service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfig {

    private static final String exchangeName = "auction.ex";
    private static final String queueName = "auction.queue";
    private static final String routingKey = "routingKey.auction";

    //* Create exchanges and queues
    @Bean
    public RabbitAdmin createRabbitAdmin(ConnectionFactory conn) {
        return new RabbitAdmin(conn);
    }

    //* Initialize Admin
    @Bean
    public ApplicationListener<ApplicationReadyEvent> initializeAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());  //* LocalDateTime
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    //* Used to send messages to RabbitMQ
    //* Rabbit Template --- Connection Factory --> RabbitMQ (JSON <-> Binary)
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return  rabbitTemplate;
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange (exchangeName);
    }

    @Bean
    public Queue auctionQueue() {
        return new Queue(queueName, true);
    }

    @Bean
    public Binding binding(Queue auctionQueue, DirectExchange directExchange) {
//        return BindingBuilder.bind(auctionQueue).to(directExchange).with(exchangeName);
        return BindingBuilder.bind(auctionQueue).to(directExchange).with(routingKey);
    }


}
