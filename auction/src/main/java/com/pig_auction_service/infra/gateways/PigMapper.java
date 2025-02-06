package com.pig_auction_service.infra.gateways;

import com.pig_auction_service.domain.entities.Auction;
import com.pig_auction_service.domain.entities.Pig;
import com.pig_auction_service.infra.persistance.AuctionEntity;
import com.pig_auction_service.infra.persistance.PigEntity;


public class PigMapper {

    public Pig toDomain(PigEntity entity, Auction auction) {
        return new Pig(entity.getName(), entity.getWeight(), entity.getAge(), entity.getBreed(), auction);
    }

    public PigEntity toEntity(Pig domain, AuctionEntity auctionEntity) {
        return new PigEntity(domain.getName(), domain.getWeight(), domain.getAge(), domain.getBreed(), auctionEntity);
    }

}
