package com.pig_auction_service.application.services;

import com.pig_auction_service.infra.persistance.AuctionEntity;
import com.pig_auction_service.infra.persistance.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {

    @Autowired
    private final AuctionRepository repository;

    public AuctionService(AuctionRepository repository) {
        this.repository = repository;
    }

    public void saveAuction (AuctionEntity auctionEntity) {
        repository.save(auctionEntity);
    }
}
