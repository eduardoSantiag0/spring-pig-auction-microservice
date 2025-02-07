package com.pig_auction_service.bid.infra.controllers;

import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record BidDTO(
        UUID bidderId,
        UUID auctionId,
        BigDecimal value,
        LocalDateTime timestamp
) {
}
