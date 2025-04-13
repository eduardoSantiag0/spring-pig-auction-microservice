package com.pig_auction_service.infra.messaging;

import com.pig_auction_service.infra.controllers.BidDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BidStatusProducer {

    @Value("${bidstatus.exchange}")
    private String exchange;

    @Value("${bidstatus.queue}")
    private String queue;

    @Value("${bidstatus.routingKey}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public BidStatusProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishBidStatus(BidStatusEvent status) {
        rabbitTemplate.convertAndSend(exchange, routingKey, status);
    }


}
