package com.pig_auction_service.infra.controllers.errors;

public class NegativeStartingPriceException extends Exception{
    public NegativeStartingPriceException(String message) {
        super(message);
    }
}
