package com.pig_auction_service.infra.controllers;

import com.pig_auction_service.domain.entities.Pig;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record AuctionDTO(
        UUID publicId,
        Pig auctionedPig,
        BigDecimal highestBid,
        BigDecimal startingPrice,
        LocalDate expirationDate,
        Boolean isFinished,
        UUID highestBidderId
) {
}
