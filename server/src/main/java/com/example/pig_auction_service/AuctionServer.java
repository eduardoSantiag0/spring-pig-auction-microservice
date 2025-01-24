package com.example.pig_auction_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AuctionServer {

	public static void main(String[] args) {
		SpringApplication.run(AuctionServer.class, args);
	}

}
