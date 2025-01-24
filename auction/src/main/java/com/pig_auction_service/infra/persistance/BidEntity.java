package com.pig_auction_service.infra.persistance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="bid")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BidEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBid;
    private Long auctionID;
    private BigDecimal value;

}
