package com.pig_auction_service.bid.application.gateway;

import com.pig_auction_service.bid.domain.entities.Bid;

import java.util.List;

public interface RepositoryBidInterface {
    Bid createBid (Bid bid);
    List<Bid> getAllBids();
}
