package com.pig_auction_service.domain.entities;

import com.pig_auction_service.domain.Breed;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Pig {

    Double weight;
    Integer age;
    Breed breed;

    Long auctionID;

    public Pig(Double weight, Integer age, Breed breed, Long auctionID) {
        this.weight = weight;
        this.age = age;
        this.breed = breed;
        this.auctionID = auctionID;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getAge() {
        return age;
    }

    public Breed getBreed() {
        return breed;
    }

    public Long getAuctionID() {
        return auctionID;
    }
}
