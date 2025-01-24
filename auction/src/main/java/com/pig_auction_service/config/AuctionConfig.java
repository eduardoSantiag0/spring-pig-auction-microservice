package com.pig_auction_service.config;

import com.pig_auction_service.application.gateways.RepositoryAuctionInterface;
import com.pig_auction_service.application.usecases.GetLiveAuctionUseCase;
import com.pig_auction_service.infra.gateways.AuctionEntityMapper;
import com.pig_auction_service.infra.gateways.AuctionRepositoryJpa;
import com.pig_auction_service.infra.persistance.AuctionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuctionConfig {

    @Bean
    GetLiveAuctionUseCase getLiveAuctionUseCase (RepositoryAuctionInterface repositoryAuctionInterface) {
        return new GetLiveAuctionUseCase (repositoryAuctionInterface);
    }

    @Bean
    AuctionRepositoryJpa createAuctionRepositoryJpa (AuctionRepository auctionRepository, AuctionEntityMapper mapper) {
        return new AuctionRepositoryJpa(auctionRepository, mapper);
    }

    @Bean
    AuctionEntityMapper createAuctionEntityMapper () {
        return new AuctionEntityMapper();
    }

}
