package com.pig_auction_service.bid.infra.messaging.erros;

public class BidNotHighEnoughException extends RuntimeException {
    public BidNotHighEnoughException(String message) {
        super(message);
    }
}