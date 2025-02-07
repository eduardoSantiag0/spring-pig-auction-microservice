package com.pig_auction_service.bid.config;

import com.pig_auction_service.bid.application.usecases.RegisterBidUseCase;
import com.pig_auction_service.bid.infra.gateways.BidMapper;
import com.pig_auction_service.bid.infra.gateways.BidRepositoryJpa;
import com.pig_auction_service.bid.infra.persistance.BidRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BidConfig {

    @Bean
    RegisterBidUseCase createRegisterBidUseCase() {
        return new RegisterBidUseCase();
    }

    @Bean
    BidRepositoryJpa createBidRepositoryJpa(BidRepository bidRepository, BidMapper bidMapper) {
        return new BidRepositoryJpa(bidRepository, bidMapper);
    }

    @Bean
    BidMapper createBidMapper() {
        return new BidMapper();
    }

}
