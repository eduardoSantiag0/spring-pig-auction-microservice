package com.pig_auction_service.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Auction {

    private final Pig auctionePig;
    private final BigDecimal startingPrice;
    private final LocalDate expiratioDate;
    private BigDecimal highestBid;
    private Boolean isFinished;

    public Auction(Pig auctionePig, BigDecimal startingPrice, LocalDate expiratioDate) {
        this.auctionePig = auctionePig;
        this.startingPrice = startingPrice;
        this.highestBid = startingPrice;
        this.expiratioDate = expiratioDate;
        this.isFinished = false;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public LocalDate getExpiratioDate() {
        return expiratioDate;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public BigDecimal getHighestBid() {
        return highestBid;
    }

    public Pig getAuctionePig() {
        return auctionePig;
    }
}
