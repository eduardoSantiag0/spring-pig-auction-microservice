package com.pig_auction_service.application.usecases;

import com.pig_auction_service.application.gateways.RepositoryAuctionInterface;
import com.pig_auction_service.domain.entities.Auction;
import com.pig_auction_service.infra.persistance.AuctionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FinishAuctionUseCase {

    private final RepositoryAuctionInterface repositoryAuctionInterface;

    public FinishAuctionUseCase(RepositoryAuctionInterface repositoryAuctionInterface) {
        this.repositoryAuctionInterface = repositoryAuctionInterface;
    }

    @Scheduled(fixedRate = 24000)
    public void execute(){
        List<AuctionEntity> liveAuctions = repositoryAuctionInterface.findByIsFinishedTrue()
                .stream()
                .filter(a -> a.getExpirationDate().isBefore(LocalDate.now()))
                        .peek(AuctionEntity::markAsExpired)
                                .toList();

        repositoryAuctionInterface.saveAll(liveAuctions);
    }
}
