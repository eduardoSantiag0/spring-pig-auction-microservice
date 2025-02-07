package com.pig_auction_service.bid.infra.persistance;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bid")

public class BidEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id", nullable = false)
    private Long bidId;

    @Column(name = "public_id", nullable = false)
    private UUID publicId;

    @Column(name = "bidder_id", nullable = false)
    private UUID bidderId;

    @Column(name = "auction_id", nullable = false)
    private UUID auctionId;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "timestamp", nullable = false)
//    @DateTimeFormat(pattern = "yyyy--MM--dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    public BidEntity( UUID bidderId, UUID auctionId, LocalDateTime timestamp, BigDecimal value) {
        this.publicId = UUID.randomUUID();
        this.bidderId = bidderId;
        this.auctionId = auctionId;
        this.timestamp = timestamp;
        this.value = value;
    }

    public BidEntity() {
    }

    public Long getBidId() {
        return bidId;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public UUID getBidderId() {
        return bidderId;
    }

    public UUID getAuctionId() {
        return auctionId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
