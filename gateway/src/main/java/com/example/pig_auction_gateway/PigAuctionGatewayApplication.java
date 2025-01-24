package com.example.pig_auction_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PigAuctionGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PigAuctionGatewayApplication.class, args);
	}

}
