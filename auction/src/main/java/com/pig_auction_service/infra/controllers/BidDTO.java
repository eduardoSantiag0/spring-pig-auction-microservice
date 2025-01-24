package com.pig_auction_service.infra.controllers;

import java.math.BigDecimal;

public record BidDTO(
        Long idBid,
        Long auctionID,
        BigDecimal value
) {
}
