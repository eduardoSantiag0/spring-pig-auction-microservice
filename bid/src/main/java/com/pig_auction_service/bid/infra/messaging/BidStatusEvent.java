package com.pig_auction_service.bid.infra.messaging;

import java.math.BigDecimal;
import java.util.UUID;

public record BidStatusEvent (
        UUID auctionId,
        UUID bidderId,
        BigDecimal value,
        boolean success,
        String message,
        UUID publicId
)
{
}
