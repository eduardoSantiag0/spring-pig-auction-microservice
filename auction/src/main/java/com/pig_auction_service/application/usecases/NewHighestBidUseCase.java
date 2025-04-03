package com.pig_auction_service.application.usecases;
import com.pig_auction_service.application.gateways.RepositoryAuctionInterface;
import com.pig_auction_service.infra.controllers.BidDTO;
import com.pig_auction_service.infra.persistance.AuctionEntity;
import com.pig_auction_service.infra.persistance.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Service
public class NewHighestBidUseCase {

    private final AuctionRepository auctionRepository;

    @Autowired
    public NewHighestBidUseCase(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }


    @Transactional
    public boolean execute (BidDTO newBid) {
        Optional<AuctionEntity> auctionFounded = auctionRepository.findByPublicId(newBid.auctionId());

        if (auctionFounded.isPresent()) {
            AuctionEntity auction = auctionFounded.get();
            System.out.println("\n\n✅ ENCONTROU NO BANCO DE DADOS!");

            if (auction.getHighestBid().compareTo(newBid.value()) < 0) {
                auction.setNewBid(newBid);
                auctionRepository.save(auction);

                System.out.println("\n\n✅ NOVA BID SALVA!");
                return true;
            }
        }
        System.out.println("\n\n NÃO ENCONTROU NO BANCO DE DADOS!");
        return false;
    }

}
