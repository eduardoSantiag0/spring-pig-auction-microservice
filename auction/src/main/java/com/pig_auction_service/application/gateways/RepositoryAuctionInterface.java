package com.pig_auction_service.application.gateways;

import com.pig_auction_service.domain.entities.Auction;
import com.pig_auction_service.infra.persistance.AuctionEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryAuctionInterface {
    Auction createAuction(Auction auction);
    List<Auction> getLiveAuctions();
    Optional<AuctionEntity> findByPublicId(UUID auctionId);
}
