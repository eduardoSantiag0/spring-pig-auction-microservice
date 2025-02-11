package com.pig_auction_service.bid.infra.messaging;

import com.pig_auction_service.bid.domain.entities.Bid;
import com.pig_auction_service.bid.infra.controllers.BidDTO;
import lombok.Value;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class BidProducer {

    private final RabbitTemplate rabbitTemplate;

    public BidProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishBid(Bid domain) {
        BidDTO dto = new BidDTO(domain.getBidderId(), domain.getAuctionId(), domain.getValue(), domain.getTimestamp());
//        rabbitTemplate.convertAndSend( "","${broker.queue}" , dto);
        rabbitTemplate.convertAndSend("${broker.queue}", dto);
    }

}
