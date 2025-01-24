package com.pig_auction_service.application.usecases;

import com.pig_auction_service.domain.entities.Auction;
import com.pig_auction_service.infra.controllers.AuctionDTO;
import org.springframework.stereotype.Service;

@Service
public class CreateAuctionUseCase {
    public Auction createAuctionUseCase (AuctionDTO dto) {
        return new Auction(dto.auctionePig(), dto.startingPrice(), dto.expiratioDate());
    }
}
