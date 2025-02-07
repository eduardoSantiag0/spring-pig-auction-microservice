package com.pig_auction_service.bid.application.services;

import com.pig_auction_service.bid.domain.entities.Bid;
import com.pig_auction_service.bid.infra.controllers.BidDTO;
import com.pig_auction_service.bid.infra.gateways.BidMapper;
import com.pig_auction_service.bid.infra.persistance.BidEntity;
import com.pig_auction_service.bid.infra.persistance.BidRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidService {

    private final BidRepository bidRepository;

    private final BidMapper bidMapper;

    public BidService(BidRepository bidRepository, BidMapper bidMapper) {
        this.bidRepository = bidRepository;
        this.bidMapper = bidMapper;
    }

    public void saveBid (BidEntity bidEntity) {
        bidRepository.save(bidEntity);
    }

    public List<BidDTO> getAllBids() {
        List<BidEntity> entities = bidRepository.findAll();

        return entities.stream()
                .map(e -> new BidDTO(e.getBidderId(), e.getAuctionId(), e.getValue(), e.getTimestamp()))
//                .map(e -> new BidDTO(e.getAuctionId(), e.getValue()))
                .collect(Collectors.toList());
    }

}
