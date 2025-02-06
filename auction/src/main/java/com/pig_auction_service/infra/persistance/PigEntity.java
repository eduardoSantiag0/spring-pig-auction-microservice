package com.pig_auction_service.infra.persistance;

import com.pig_auction_service.domain.Breed;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pigs")
//@NoArgsConstructor
public class PigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pig_id", nullable = false)
    private Long pigID;

    @Column(name = "name", nullable = false)
    private String name;

    // Indica que PigEntity não comanda na relação
    @OneToOne(mappedBy = "auctionedPig", cascade = CascadeType.ALL)
//    @OneToOne(mappedBy = "auctionedPig", cascade = CascadeType.ALL)
//    @Column(name = "auction")
    private AuctionEntity auction;

    @Column(name = "weight",nullable = false)
    Double weight;

    @Column(name = "age",nullable = false)
    Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "breed", nullable = false)
    Breed breed;

    public PigEntity(String name, Double weight, Integer age, Breed breed, AuctionEntity auction) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.breed = breed;
        this.auction = auction;
    }

    public PigEntity(String name, Double weight, Integer age, Breed breed) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.breed = breed;
    }

    public PigEntity() {
    }

    public void setAuctionID(AuctionEntity auction) {
        this.auction = auction;
    }

    public Long getPigID() {
        return pigID;
    }

    public String getName() {
        return name;
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

    public AuctionEntity getAuctionID() {
        return auction;
    }
}
