package com.pig_auction_service.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pig_auction_service.domain.Breed;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
public class Pig {

    private String name;

    @JsonIgnore
    private Auction auction;

    private Double weight;
    private Integer age;
    private Breed breed;


    public Pig() { }

    public Pig(String name, Double weight, Integer age, Breed breed, Auction auction) {

        if (age <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Atributes must be greater than zero.");
        }

        this.name = name;
        this.weight = weight;
        this.age = age;
        this.breed = breed;
        this.auction = auction;
    }




    public String getName() {
        return name;
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

    public Auction getAuction() {
        return auction;
    }
}
