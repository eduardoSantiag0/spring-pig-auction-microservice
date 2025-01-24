package com.pig_auction_service.infra.controllers;

import com.pig_auction_service.domain.entities.Pig;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AuctionDTO(
        Pig auctionePig,
        BigDecimal highestBid,
        BigDecimal startingPrice,
        LocalDate expiratioDate,
        Boolean isFinished
) {
}
