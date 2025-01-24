package com.pig_auction_service.infra.persistance;

import com.pig_auction_service.domain.Breed;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pigs")
@NoArgsConstructor
public class PigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pigID;

    private Long auctionID;

    @Column(nullable = false)
    Double weight;

    @Column(nullable = false)
    Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Breed breed;

    public PigEntity(Double weight, Integer age, Breed breed, Long auctionID) {
        this.weight = weight;
        this.age = age;
        this.breed = breed;
        this.auctionID = auctionID;
    }

    public Long getPigID() {
        return pigID;
    }

    public Breed getBreed() {
        return breed;
    }

    public Integer getAge() {
        return age;
    }

    public Double getWeight() {
        return weight;
    }

    public Long getAuctionID() {
        return auctionID;
    }
}
