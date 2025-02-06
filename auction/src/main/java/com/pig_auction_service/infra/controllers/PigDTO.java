package com.pig_auction_service.infra.controllers;

import com.pig_auction_service.domain.Breed;
import com.pig_auction_service.domain.entities.Auction;

public record PigDTO(
        String name,
        Auction auctionID,
        Double weight,
        Integer age,
        Breed breed
) {
}
