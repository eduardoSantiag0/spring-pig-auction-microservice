package com.pig_auction_service.infra.messaging;

import com.pig_auction_service.infra.controllers.BidDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AuctionListener {

    @RabbitListener(queues = "auction.queue")
    public void listen (@Payload BidDTO newBid) {
        System.out.println("\tOUVINDO");
        System.out.println(newBid);
    }

    @RabbitListener(queues = "auction.queue")
    public void listen (@Payload String m) {
        System.out.println(m);
    }

}
