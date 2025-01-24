package com.pig_auction_service.infra.persistance;

import com.pig_auction_service.domain.entities.Pig;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="auction")
@AllArgsConstructor
@NoArgsConstructor
//@Getter
public class AuctionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionID;


    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "pigID", referencedColumnName = "pigID")
    private PigEntity auctionePig;

    private BigDecimal highestBid;
    private BigDecimal startingPrice;
    private LocalDate expiratioDate;
    private Boolean isFinished;


    public AuctionEntity(PigEntity auctionePig, BigDecimal highestBid, BigDecimal startingPrice, LocalDate expiratioDate) {
        this.auctionePig = auctionePig;
        this.highestBid = highestBid;
        this.startingPrice = startingPrice;
        this.expiratioDate = expiratioDate;
        this.isFinished = false;
    }

    public Long getAuctionID() {
        return auctionID;
    }

    public PigEntity getAuctionePig() {
        return auctionePig;
    }

    public BigDecimal getHighestBid() {
        return highestBid;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public LocalDate getExpiratioDate() {
        return expiratioDate;
    }

    public Boolean getFinished() {
        return isFinished;
    }
}
