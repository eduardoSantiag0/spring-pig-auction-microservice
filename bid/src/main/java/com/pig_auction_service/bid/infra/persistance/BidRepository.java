package com.pig_auction_service.bid.infra.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<BidEntity, Long> {
}
