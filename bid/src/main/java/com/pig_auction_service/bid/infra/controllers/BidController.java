package com.pig_auction_service.bid.infra.controllers;

import com.pig_auction_service.bid.application.services.BidService;
import com.pig_auction_service.bid.application.usecases.RegisterBidUseCase;
import com.pig_auction_service.bid.domain.entities.Bid;
import com.pig_auction_service.bid.infra.gateways.BidMapper;
import com.pig_auction_service.bid.infra.messaging.erros.BidNotHighEnoughException;
import com.pig_auction_service.bid.infra.persistance.BidEntity;
import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/bid")
public class BidController {

    @Autowired
    private final RegisterBidUseCase registerBidUseCase;

    @Autowired
    private final BidMapper mapper;

    @Autowired
    private final BidService service;

    public BidController(RegisterBidUseCase registerBidUseCase, BidMapper mapper, BidService service) {
        this.registerBidUseCase = registerBidUseCase;
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<BidDTO> createBid (@Validated @RequestBody BidDTO bidDTO) {
        Bid bidDomain = registerBidUseCase.execute(bidDTO);
        BidEntity bidEntity = mapper.toEntity(bidDomain);

        service.publishAndSaveBid(bidEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new BidDTO (bidEntity.getBidderId(), bidEntity.getAuctionId(), bidEntity.getValue(), bidEntity.getTimestamp(), bidEntity.getPublicId() ,bidEntity.isSuccess()));

    }

    @GetMapping("/all")
    public ResponseEntity<List<BidDTO>> getAllBids () {
        return ResponseEntity.ok(service.getAllBids());
    }

    @GetMapping("/status/{publicId}")
    public ResponseEntity<?> getStatusById(@PathVariable String publicId) {
        Optional<BidDTO> dto  = service.getBidByPublicId(UUID.fromString(publicId));

        if (dto.isPresent()) {
            return ResponseEntity.ok(dto.get());
        }

        return (ResponseEntity<?>) ResponseEntity.notFound();
    }


}


