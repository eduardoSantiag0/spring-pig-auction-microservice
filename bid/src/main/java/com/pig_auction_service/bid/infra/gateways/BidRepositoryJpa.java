package com.pig_auction_service.bid.infra.gateways;

import com.pig_auction_service.bid.application.gateway.RepositoryBidInterface;
import com.pig_auction_service.bid.domain.entities.Bid;
import com.pig_auction_service.bid.infra.persistance.BidRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BidRepositoryJpa implements RepositoryBidInterface {
    private final BidRepository bidRepository;
    private final BidMapper bidMapper;

    public BidRepositoryJpa(BidRepository bidRepository, BidMapper bidMapper) {
        this.bidRepository = bidRepository;
        this.bidMapper = bidMapper;
    }


    @Override
    public Bid createBid(Bid bid) {
        return null;
    }

    @Override
    public List<Bid> getAllBids() {
        return bidRepository.findAll().stream()
                .map(bidMapper::toDomain)
                .collect(Collectors.toList());
    }
}
