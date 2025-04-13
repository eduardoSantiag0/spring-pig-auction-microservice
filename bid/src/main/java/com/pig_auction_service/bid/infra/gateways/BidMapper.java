package com.pig_auction_service.bid.infra.gateways;

import com.pig_auction_service.bid.domain.entities.Bid;
import com.pig_auction_service.bid.infra.controllers.BidDTO;
import com.pig_auction_service.bid.infra.persistance.BidEntity;

public class BidMapper {


    public Bid toDomain (BidEntity entity) {
        return new Bid(entity.getAuctionId(), entity.getValue(), entity.getBidderId(), entity.getPublicId(), entity.isSuccess());
    }

    public BidEntity toEntity (Bid domain) {
        return new BidEntity(domain.getBidderId(), domain.getAuctionId(),
                domain.getTimestamp(), domain.getValue(), domain.isSuccess());
    }

    public BidDTO toDTO (Bid domain) {
        return new BidDTO(domain.getBidderId(), domain.getAuctionId(), domain.getValue(), domain.getTimestamp(), domain.getPublicId(), domain.isSuccess());

    }

}
