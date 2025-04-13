package com.pig_auction_service.bid.infra.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BidRepository extends JpaRepository<BidEntity, Long> {

    Optional<BidEntity> findByPublicId(UUID id);

}
