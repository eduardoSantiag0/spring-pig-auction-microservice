package com.pig_auction_service.application.usecases;

import com.pig_auction_service.application.gateways.RepositoryAuctionInterface;
import com.pig_auction_service.domain.entities.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetLiveAuctionUseCase {


    @Autowired
    private final RepositoryAuctionInterface repositoryAuctionInterface;

    public GetLiveAuctionUseCase(RepositoryAuctionInterface repositoryAuctionInterface) {
        this.repositoryAuctionInterface = repositoryAuctionInterface;
    }

    @Bean
    public List<Auction> execute() {
        return repositoryAuctionInterface.getLiveAuctions();
    }
}
