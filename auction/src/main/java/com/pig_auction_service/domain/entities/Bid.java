package com.pig_auction_service.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//@AllArgsConstructor
@Getter
@Setter
public class Bid {
    private final Long idBid;
    private final Long auctionId;
    private final BigDecimal value;
    private final LocalDateTime timestamp;


    public Bid(Long idBid, Long auctionId, BigDecimal value, LocalDateTime timestamp) {

        if (auctionId == null || value == null || timestamp == null) {
            throw new IllegalArgumentException("Null parameters error.");
        }

        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bid amount must be greater than zero.");
        }
        this.idBid = idBid;
        this.auctionId = auctionId;
        this.value = value;
        this.timestamp = timestamp;
    }
}
