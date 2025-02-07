//package com.pig_auction_service.infra.messaging;
//
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AuctionAMQPConfiguration {
//
//    //* Create exchanges and queues
//    @Bean
//    public RabbitAdmin createRabbitAdmin(ConnectionFactory conn) {
//        return new RabbitAdmin(conn);
//    }
//
//    //* Initialize Admin
//    @Bean
//    public ApplicationListener<ApplicationReadyEvent> initializeAdmin(RabbitAdmin rabbitAdmin){
//        return event -> rabbitAdmin.initialize();
//    }
//
//    //* RabbitMQ uses binary. Jackson converts Java Objets to binary
//    @Bean
//    public Jackson2JsonMessageConverter messageConverter(){
//        return  new Jackson2JsonMessageConverter();
//    }
//
//    //* Used to send messages to RabbitMQ
//    //* Rabbit Template --- Connection Factory --> RabbitMQ
//    //* Convert Objets to Binaries
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
//                                         Jackson2JsonMessageConverter messageConverter) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(messageConverter);
//        return  rabbitTemplate;
//    }
//
//    @Bean
//    public DirectExchange directExchange(){
//        return new DirectExchange ("auction.ex");
//    }
//
//}
