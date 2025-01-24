package com.pig_auction_service.application.gateways;

import com.pig_auction_service.domain.entities.Auction;
import java.util.List;

public interface RepositoryAuctionInterface {
    Auction createAuction(Auction auction);
    List<Auction> getLiveAuctions();
}
