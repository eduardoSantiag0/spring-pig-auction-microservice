package com.pig_auction_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PigAuctionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigAuctionServiceApplication.class, args);
    }

}
