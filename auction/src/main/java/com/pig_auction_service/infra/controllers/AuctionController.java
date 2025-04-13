package com.pig_auction_service.infra.controllers;

import com.pig_auction_service.application.services.AuctionService;
import com.pig_auction_service.application.usecases.CreateAuctionUseCase;
import com.pig_auction_service.application.usecases.GetLiveAuctionUseCase;
import com.pig_auction_service.domain.entities.Auction;
import com.pig_auction_service.infra.controllers.errors.NegativeStartingPriceException;
import com.pig_auction_service.infra.gateways.AuctionEntityMapper;
import com.pig_auction_service.infra.persistance.AuctionEntity;
import com.pig_auction_service.infra.persistance.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/auction")
public class AuctionController {

    private final CreateAuctionUseCase createAuctionUseCase;
    private final GetLiveAuctionUseCase getLiveAuctionUseCase;

    @Autowired
    private final AuctionEntityMapper mapper;

    @Autowired
    private final AuctionService service;


    public AuctionController(CreateAuctionUseCase createAuctionUseCase, GetLiveAuctionUseCase getLiveAuctionUseCase, AuctionEntityMapper mapper, AuctionService service) {
        this.createAuctionUseCase = createAuctionUseCase;
        this.getLiveAuctionUseCase = getLiveAuctionUseCase;
        this.mapper = mapper;
        this.service = service;
    }


    @PostMapping("/create")
    public ResponseEntity<AuctionDTO> createAuction ( @Validated @RequestBody AuctionDTO auctionDTO) throws NegativeStartingPriceException {

        if (auctionDTO.startingPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new NegativeStartingPriceException("Zero ou Negative number is not possible.");
        }

        Auction auctionDomain = createAuctionUseCase.execute(auctionDTO);
        AuctionEntity auctionEntity = mapper.toEntity(auctionDomain);

        service.saveAuction(auctionEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new AuctionDTO(auctionDomain.getAuctionedPig(), auctionDomain.getHighestBid(),
                        auctionDomain.getStartingPrice(), auctionDomain.getExpirationDate(), auctionDomain.getFinished(), null));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuctionDTO>> getLiveAuctions (@RequestParam(defaultValue = "0") Integer pageNo,
                                                             @RequestParam(defaultValue = "10") Integer pageSize) {

        List<AuctionDTO> dtoList = getLiveAuctionUseCase.executePaging(pageNo, pageSize).stream()
                .map(mapper::toDomain)
                .map( auction -> new AuctionDTO(auction.getAuctionedPig(), auction.getHighestBid(),
                auction.getStartingPrice(), auction.getExpirationDate(), auction.getFinished(), auction.getHighestBidderId()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }



}
