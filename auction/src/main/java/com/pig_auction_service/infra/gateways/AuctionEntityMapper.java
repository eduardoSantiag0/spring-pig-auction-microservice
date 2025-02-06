package com.pig_auction_service.infra.gateways;

import com.pig_auction_service.domain.entities.Auction;
import com.pig_auction_service.domain.entities.Pig;
import com.pig_auction_service.infra.persistance.AuctionEntity;
import com.pig_auction_service.infra.persistance.PigEntity;

public class AuctionEntityMapper {

    private final PigMapper pigMapper;

    public AuctionEntityMapper(PigMapper pigMapper) {
        this.pigMapper = pigMapper;
    }

    public AuctionEntity toEntity (Auction auction) {
        PigEntity pigEntity = pigMapper.toEntity(auction.getAuctionedPig(),null );

        AuctionEntity newAuction = new AuctionEntity (pigEntity, auction.getHighestBid(), auction.getStartingPrice(),
                auction.getExpirationDate());

        pigEntity.setAuctionID(newAuction);

        return newAuction;
    }

    public Auction toDomain (AuctionEntity auctionEntity) {
        Pig pigDomain = pigMapper.toDomain(auctionEntity.getAuctionePig(), null);

        return new Auction( pigDomain, auctionEntity.getHighestBid(), auctionEntity.getExpirationDate());
    }
}
