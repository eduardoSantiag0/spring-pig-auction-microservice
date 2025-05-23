package com.pig_auction_service.bid.domain.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Bid {

//    @NonNull
//    private final Long bidId;

    @NonNull
    private final UUID bidderId;

    @NonNull
    private final UUID auctionId;

    @NonNull
    private final BigDecimal value;

    @NonNull
    private final LocalDateTime timestamp;

    @NonNull
    private final UUID publicId;

    private final boolean success;


    public Bid(UUID auctionId, BigDecimal value, UUID publicId) {

        if (auctionId == null || value == null ) {
            throw new IllegalArgumentException("Null parameters error.");
        }

        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bid amount must be greater than zero.");
        }
        this.bidderId = UUID.randomUUID();
        this.auctionId = auctionId;
        this.value = value;
        this.timestamp = LocalDateTime.now();
        this.publicId = publicId;
        this.success = false;

    }

    public Bid(UUID auctionId, BigDecimal value, UUID bidderId, UUID publicId , boolean success) {

        if (auctionId == null || value == null ) {
            throw new IllegalArgumentException("Null parameters error.");
        }

        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bid amount must be greater than zero.");
        }
        this.bidderId = bidderId;
        this.auctionId = auctionId;
        this.value = value;
        this.timestamp = LocalDateTime.now();
        this.publicId = publicId;
        this.success = success;

    }


}
