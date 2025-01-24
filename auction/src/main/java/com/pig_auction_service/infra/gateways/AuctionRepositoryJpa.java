package com.pig_auction_service.infra.gateways;

import com.pig_auction_service.application.gateways.RepositoryAuctionInterface;
import com.pig_auction_service.domain.entities.Auction;
import com.pig_auction_service.infra.persistance.AuctionEntity;
import com.pig_auction_service.infra.persistance.AuctionRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AuctionRepositoryJpa implements RepositoryAuctionInterface {
    private final AuctionRepository auctionRepository;
    private final AuctionEntityMapper auctionEntityMapper;

    public AuctionRepositoryJpa(AuctionRepository auctionRepository, AuctionEntityMapper auctionEntityMapper) {
        this.auctionRepository = auctionRepository;
        this.auctionEntityMapper = auctionEntityMapper;
    }

    @Override
    public Auction createAuction(Auction auction) {
        AuctionEntity entity = auctionEntityMapper.toEntity(auction);
        auctionRepository.save(entity);
        return auctionEntityMapper.toDomain(entity);
    }

    @Override
    public List<Auction> getLiveAuctions() {
        return auctionRepository.findAll().stream()
                .map(auctionEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
