package com.pig_auction_service.infra.gateways;

import com.pig_auction_service.domain.entities.Pig;
import com.pig_auction_service.infra.persistance.PigEntity;

public class PigMapper {
    public static Pig toDomain(PigEntity entity) {
        return new Pig(entity.getWeight(), entity.getAge(), entity.getBreed(), entity.getAuctionID());
    }

    public static PigEntity toEntity(Pig domain) {
        return new PigEntity(domain.getWeight(), domain.getAge(), domain.getBreed(), domain.getAuctionID());
    }
}
