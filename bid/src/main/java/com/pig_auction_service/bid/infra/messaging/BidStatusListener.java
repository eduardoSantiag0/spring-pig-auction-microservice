package com.pig_auction_service.bid.infra.messaging;

import com.pig_auction_service.bid.infra.persistance.BidEntity;
import com.pig_auction_service.bid.infra.persistance.BidRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BidStatusListener {

    @Autowired
    private BidRepository repository;

    @RabbitListener (queues = "auction.bid.status.queue")
    public void listen (@Payload BidStatusEvent status) {
        if (!status.success()) {
            System.out.println(status);
        }

        Optional<BidEntity> entity = repository.findByPublicId(status.publicId());

        entity.ifPresent( e -> {
            e.setSuccess(status.success());
            repository.save(e);
        });


        System.out.println(status);
    }

}
