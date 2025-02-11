package com.pig_auction_service.infra.controllers;

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

