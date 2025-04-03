package com.pig_auction_service.bid.infra.gateways;

import com.pig_auction_service.bid.domain.entities.Bid;
import com.pig_auction_service.bid.infra.controllers.BidDTO;
import com.pig_auction_service.bid.infra.persistance.BidEntity;

public class BidMapper {


    public Bid toDomain (BidEntity entity) {
        return new Bid(entity.getAuctionId(), entity.getValue(), entity.getBidderId());
    }

    public BidEntity toEntity (Bid domain) {
        return new BidEntity(domain.getBidderId(), domain.getAuctionId(),
                domain.getTimestamp(), domain.getValue());
    }

}
