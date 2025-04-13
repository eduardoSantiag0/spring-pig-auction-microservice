package com.pig_auction_service.bid.application.usecases;

import com.pig_auction_service.bid.domain.entities.Bid;
import com.pig_auction_service.bid.infra.controllers.BidDTO;
import org.springframework.stereotype.Service;

@Service
public class RegisterBidUseCase {
    public Bid execute (BidDTO dto) {
        return new Bid(dto.auctionId(), dto.value(), dto.publicId());
    }
}
