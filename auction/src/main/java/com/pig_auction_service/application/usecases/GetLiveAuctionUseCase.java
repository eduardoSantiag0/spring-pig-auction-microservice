package com.pig_auction_service.application.usecases;

import com.pig_auction_service.application.gateways.RepositoryAuctionInterface;
import com.pig_auction_service.infra.persistance.AuctionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetLiveAuctionUseCase {

    @Autowired
    private final RepositoryAuctionInterface repositoryAuctionInterface;

    public GetLiveAuctionUseCase(RepositoryAuctionInterface repositoryAuctionInterface) {
        this.repositoryAuctionInterface = repositoryAuctionInterface;
    }

    public List<AuctionEntity> execute() {
//        return repositoryAuctionInterface.getLiveAuctions();
        return repositoryAuctionInterface.findByIsFinishedTrue();
    }

    public List<AuctionEntity> executePaging(Integer pageNo, Integer pageSize) {
        return repositoryAuctionInterface.findByIsFinishedFalseOrderByExpirationDateAsc(PageRequest.of(pageNo, pageSize));
    }

//    public List<Auction> executeDDTO() {
//        return repositoryAuctionInterface.getLiveAuctionsDomain();
//    }
}
