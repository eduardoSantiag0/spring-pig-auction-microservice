package com.pig_auction_service.infra.messaging;

import com.pig_auction_service.application.usecases.NewHighestBidUseCase;
import com.pig_auction_service.infra.controllers.BidDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AuctionListener {

    private final NewHighestBidUseCase newHighestBidUseCase;

    public AuctionListener(NewHighestBidUseCase newHighestBidUseCase) {
        this.newHighestBidUseCase = newHighestBidUseCase;
    }

    @RabbitListener(queues = "auction.queue")
    public void listen (@Payload BidDTO newBid)  {
        System.out.println("\t \uD83D\uDCE2 OUVINDO");
        System.out.println(newBid);

        newHighestBidUseCase.execute(newBid);

    }

}
