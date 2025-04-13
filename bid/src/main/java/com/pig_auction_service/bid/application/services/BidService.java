package com.pig_auction_service.bid.application.services;

import com.pig_auction_service.bid.infra.controllers.BidDTO;
import com.pig_auction_service.bid.infra.gateways.BidMapper;
import com.pig_auction_service.bid.infra.messaging.BidProducer;
import com.pig_auction_service.bid.infra.messaging.erros.BidNotHighEnoughException;
import com.pig_auction_service.bid.infra.persistance.BidEntity;
import com.pig_auction_service.bid.infra.persistance.BidRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BidService {

    private final BidRepository bidRepository;

    private final BidMapper bidMapper;

    private final BidProducer bidProducer;

    public BidService(BidRepository bidRepository, BidMapper bidMapper, BidProducer bidProducer) {
        this.bidRepository = bidRepository;
        this.bidMapper = bidMapper;
        this.bidProducer = bidProducer;
    }

    @Transactional
    public void publishAndSaveBid(BidEntity bidEntity) throws BidNotHighEnoughException {
        var domain = bidMapper.toDomain(bidEntity);
        bidProducer.publishBid(domain);
//        BidStatusEvent bidStatus = bidProducer.publishBid(domain);

//        if (!bidStatus.success()) {
//            System.out.println(bidStatus);
//            throw new BidNotHighEnoughException("Bid must be higher");
//        }
        bidRepository.save(bidEntity);
        System.out.println("\uD83D\uDC4D SALVO COM SUCESSO ");

    }

    public List<BidDTO> getAllBids() {
        List<BidEntity> entities = bidRepository.findAll();

        return entities.stream()
                .map(e -> new BidDTO(e.getBidderId(), e.getAuctionId(), e.getValue(), e.getTimestamp(), e.getPublicId(), e.isSuccess()))
                .collect(Collectors.toList());
    }

    public Optional<BidDTO> getBidByPublicId(UUID id) {

        Optional<BidEntity> entity = bidRepository.findByPublicId(id);

        if (entity.isPresent()) {
            BidDTO dto = bidMapper.toDTO(bidMapper.toDomain(entity.get()));
            return Optional.of(dto);
        }

        return Optional.empty();
    }

}
