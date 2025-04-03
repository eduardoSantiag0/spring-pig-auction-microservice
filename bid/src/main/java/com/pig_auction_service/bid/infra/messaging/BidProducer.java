package com.pig_auction_service.bid.infra.messaging;

import com.pig_auction_service.bid.domain.entities.Bid;
import com.pig_auction_service.bid.infra.controllers.BidDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BidProducer {

    @Value("${broker.exchange}")
    private String exchange;

    @Value("${broker.queue}")
    private String queue;

    @Value("${broker.routingKey}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public BidProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishBid(Bid domain) {
        BidDTO dto = new BidDTO(domain.getBidderId(), domain.getAuctionId(), domain.getValue(), domain.getTimestamp());

        System.out.println("In the following exchange: " + exchange);
        System.out.println("Using this routing key: " + routingKey);
        System.out.println(dto);

        rabbitTemplate.convertAndSend(exchange, routingKey, dto);
    }

}
