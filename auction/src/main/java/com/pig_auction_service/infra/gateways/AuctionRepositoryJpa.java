//package com.pig_auction_service.infra.gateways;
//
//import com.pig_auction_service.application.gateways.RepositoryAuctionInterface;
//import com.pig_auction_service.domain.entities.Auction;
//import com.pig_auction_service.infra.persistance.AuctionEntity;
//import com.pig_auction_service.infra.persistance.AuctionRepository;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.stream.Collectors;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//@Service
//@Repository
//public class AuctionRepositoryJpa implements RepositoryAuctionInterface {
//    private final AuctionRepository auctionRepository;
//    private final AuctionEntityMapper auctionEntityMapper;
//
//    public AuctionRepositoryJpa(AuctionRepository auctionRepository, AuctionEntityMapper auctionEntityMapper) {
//        this.auctionRepository = auctionRepository;
//        this.auctionEntityMapper = auctionEntityMapper;
//    }
//
//    @Override
//    public Auction createAuction(Auction auction) {
//        AuctionEntity entity = auctionEntityMapper.toEntity(auction);
//        auctionRepository.save(entity);
//        return auctionEntityMapper.toDomain(entity);
//    }
//
//    @Override
//    public List<AuctionEntity> getLiveAuctions() {
//        return auctionRepository.findAll()
//                .stream()
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<AuctionEntity> getLiveAuctions(int pageNo, int pageSize) {
//
//        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
//
//        Page<AuctionEntity> pagingAuction = auctionRepository.findAll(pageRequest);
//
//        return pagingAuction.getContent();
//
////        return auctionRepository.findAll()
////                .stream()
////                .map(auctionEntityMapper::toDomain)
////                .collect(Collectors.toList());
//    }
//
//
//    @Override
//    public Optional<AuctionEntity> findByPublicId(UUID auctionId) {
////        return auctionRepository.findByPublicId(auctionId)
////                .map(auctionEntityMapper::toEntity);
//        return auctionRepository.findByPublicId(auctionId);
//    }
//
//    @Override
//    public void banana(List<AuctionEntity> auctions) {
//        auctionRepository.saveAll(auctions);
//    }
//
//
//    @Override
//    public Iterable<AuctionEntity> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<AuctionEntity> findAll(Pageable pageable) {
//        return null;
//    }
//}
