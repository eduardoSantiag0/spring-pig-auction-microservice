package com.pig_auction_service.infra.controllers;

import com.pig_auction_service.application.usecases.CreateAuctionUseCase;
import com.pig_auction_service.application.usecases.GetLiveAuctionUseCase;
import com.pig_auction_service.domain.entities.Auction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/auction")
public class AuctionController {

    private final CreateAuctionUseCase createAuctionUseCase;

    private final GetLiveAuctionUseCase getLiveAuctionUseCase;

    public AuctionController(CreateAuctionUseCase createAuctionUseCase, GetLiveAuctionUseCase getLiveAuctionUseCase) {
        this.createAuctionUseCase = createAuctionUseCase;
        this.getLiveAuctionUseCase = getLiveAuctionUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<AuctionDTO> createAuction (@RequestBody AuctionDTO auctionDTO) {
        Auction newAuction = createAuctionUseCase.createAuctionUseCase(auctionDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new AuctionDTO(newAuction.getAuctionePig(), newAuction.getHighestBid(),
                        newAuction.getStartingPrice(), newAuction.getExpiratioDate(), newAuction.getFinished()));

    }

    @GetMapping("/all")
    public ResponseEntity<List<AuctionDTO>> getLiveAuctions () {
        List<AuctionDTO> dtoList = getLiveAuctionUseCase.getLiveAuction().stream().map( auction -> new AuctionDTO(auction.getAuctionePig(), auction.getHighestBid(),
                auction.getStartingPrice(), auction.getExpiratioDate(), auction.getFinished()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }


}
