package com.pig_auction_service.infra.gateways;

import com.pig_auction_service.domain.entities.Auction;
import com.pig_auction_service.domain.entities.Pig;
import com.pig_auction_service.infra.persistance.AuctionEntity;
import com.pig_auction_service.infra.persistance.PigEntity;

public class AuctionEntityMapper {


    public AuctionEntity toEntity (Auction auction) {
        PigEntity pigEntity = PigMapper.toEntity(auction.getAuctionePig());
        return new AuctionEntity (pigEntity, auction.getHighestBid(), auction.getStartingPrice(),
                auction.getExpiratioDate());
    }

    public Auction toDomain (AuctionEntity auctionEntity) {
        Pig pigDomain = PigMapper.toDomain(auctionEntity.getAuctionePig());
        return new Auction( pigDomain, auctionEntity.getHighestBid(), auctionEntity.getExpiratioDate());
    }
}
