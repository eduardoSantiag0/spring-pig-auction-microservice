package com.pig_auction_service.domain.entities;

import com.pig_auction_service.domain.Breed;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Auction {

    @NonNull
    private final Pig auctionedPig;

    @NonNull
    private final BigDecimal startingPrice;

    @NonNull
    private final LocalDate expirationDate;

    @NonNull
    private BigDecimal highestBid;

    private UUID highestBidderId;

    private Boolean isFinished;

    public Auction(Pig auctionedPig, BigDecimal startingPrice, LocalDate expirationDate) {
        if (startingPrice.compareTo(BigDecimal.ZERO) <= 0 ) {
            throw new IllegalArgumentException("Starting price needs to be greater than zero.");
        }

//        if (expirationDate.isBefore(LocalDate.now())) {
//            throw new IllegalArgumentException("Expiration date must be in the future..");
//        }

        this.auctionedPig = auctionedPig;
        this.startingPrice = startingPrice;
        this.highestBid = startingPrice;
        this.expirationDate = expirationDate;
        this.isFinished = false;
        this.highestBidderId = null;
    }


    public Boolean getFinished() {
        return isFinished;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public BigDecimal getHighestBid() {
        return highestBid;
    }

    public Pig getAuctionedPig() {
        return auctionedPig;
    }

    public UUID getHighestBidderId() {
        return highestBidderId;
    }
}
