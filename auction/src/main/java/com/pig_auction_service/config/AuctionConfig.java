package com.pig_auction_service.config;

import com.pig_auction_service.application.gateways.RepositoryAuctionInterface;
import com.pig_auction_service.application.usecases.GetLiveAuctionUseCase;
import com.pig_auction_service.application.usecases.NewHighestBidUseCase;
import com.pig_auction_service.infra.gateways.AuctionEntityMapper;
//import com.pig_auction_service.infra.gateways.AuctionRepositoryJpa;
import com.pig_auction_service.infra.gateways.PigMapper;
import com.pig_auction_service.infra.messaging.BidStatusProducer;
import com.pig_auction_service.infra.persistance.AuctionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuctionConfig {

    @Bean
    GetLiveAuctionUseCase getLiveAuctionUseCase (RepositoryAuctionInterface repositoryAuctionInterface) {
        return new GetLiveAuctionUseCase (repositoryAuctionInterface);
    }

//    @Bean
//    AuctionRepositoryJpa createAuctionRepositoryJpa (AuctionRepository auctionRepository, AuctionEntityMapper mapper) {
//        return new AuctionRepositoryJpa(auctionRepository, mapper);
//    }

    @Bean
    AuctionEntityMapper createAuctionEntityMapper (PigMapper pigMapper) {
        return new AuctionEntityMapper(pigMapper);
    }


    @Bean
    PigMapper createPigEntityMapper () {
        return new PigMapper();
    }

    @Bean
    NewHighestBidUseCase createNewHighestBidUseCase (AuctionRepository auctionRepository, BidStatusProducer bidStatusProducer) {
        return new NewHighestBidUseCase(auctionRepository,bidStatusProducer);
    }


}
