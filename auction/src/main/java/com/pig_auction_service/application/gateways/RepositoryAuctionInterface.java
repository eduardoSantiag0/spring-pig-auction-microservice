package com.pig_auction_service.application.gateways;

import com.pig_auction_service.infra.persistance.AuctionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositoryAuctionInterface extends JpaRepository<AuctionEntity, UUID> {
//    Optional<AuctionEntity> findByPublicId(UUID auctionId);
    List<AuctionEntity> findByIsFinishedTrue();
    List<AuctionEntity> findByIsFinishedTrueOrderByExpirationDateAsc(Pageable pageable);
}
