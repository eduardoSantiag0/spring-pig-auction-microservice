package com.pig_auction_service.application.usecases;
import com.pig_auction_service.infra.controllers.BidDTO;
import com.pig_auction_service.infra.messaging.BidStatusEvent;
import com.pig_auction_service.infra.messaging.BidStatusProducer;
import com.pig_auction_service.infra.persistance.AuctionEntity;
import com.pig_auction_service.infra.persistance.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class NewHighestBidUseCase {

    private final AuctionRepository auctionRepository;
    private final BidStatusProducer bidStatusProducer;

    @Autowired
    public NewHighestBidUseCase(AuctionRepository auctionRepository, BidStatusProducer bidStatusProducer) {
        this.auctionRepository = auctionRepository;
        this.bidStatusProducer = bidStatusProducer;
    }


    @Transactional
    public void execute (BidDTO newBid)  {
        Optional<AuctionEntity> auctionFounded = auctionRepository.findByPublicId(newBid.auctionId());
        boolean success;
        String message;

        if (auctionFounded.isPresent()) {
            AuctionEntity auction = auctionFounded.get();
            System.out.println("\n\n✅ ENCONTROU NO BANCO DE DADOS!");

            if (auction.getHighestBid().compareTo(newBid.value()) < 0) {
                auction.setNewBid(newBid);
                auctionRepository.save(auction);

                System.out.println("\n\n✅ NOVA BID SALVA!");
                message = "New bid registered";
                success = true;
            } else {
                System.out.println("\n\n MUITO BAIXA! ");
                message = "Bid must be higher than the current highest bid.";
                success = false;
//                throw new BidNotHighEnoughException("Bid must be higher than the current highest bid.");
            }

        } else {
            message = "Auction not found in database";
            success = false;
        }

        BidStatusEvent status = new BidStatusEvent(newBid.auctionId(), newBid.bidderId(), newBid.value(), success, message, newBid.publicId());

        bidStatusProducer.publishBidStatus(status);

    }

}
