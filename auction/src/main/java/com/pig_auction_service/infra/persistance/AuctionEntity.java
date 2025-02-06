package com.pig_auction_service.infra.persistance;

import com.pig_auction_service.domain.entities.Pig;
import com.pig_auction_service.infra.controllers.PigDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="auction")
@AllArgsConstructor
//@NoArgsConstructor
//@Getter
public class AuctionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_id", nullable = false)
    private Long auctionID;

    @Column(name = "public_id")
    private  UUID publicId;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "pig_id", referencedColumnName = "pig_id", nullable = false)
    private PigEntity auctionedPig;

    @Column(name = "highest_bid", nullable = false)
    private BigDecimal highestBid;

    @Column(name = "starting_price", nullable = false)
    private BigDecimal startingPrice;

    @DateTimeFormat(pattern = "yyyy--MM--dd")
    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "is_finished", nullable = false)
    private Boolean isFinished;


    public AuctionEntity(PigEntity auctionedPig, BigDecimal highestBid, BigDecimal startingPrice, LocalDate expirationDate) {
        this.auctionedPig = auctionedPig;
        this.highestBid = highestBid;
        this.startingPrice = startingPrice;
        this.expirationDate = expirationDate;
        this.isFinished = false;
        this.publicId = UUID.randomUUID();
    }

    public AuctionEntity() {
    }

    public UUID getPubID() {
        return publicId;
    }


    public Long getAuction() {
        return auctionID;
    }

    public PigEntity getAuctionePig() {
        return auctionedPig;
    }

    public BigDecimal getHighestBid() {
        return highestBid;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Boolean getFinished() {
        return isFinished;
    }
}
