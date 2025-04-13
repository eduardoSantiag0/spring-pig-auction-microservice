package com.pig_auction_service.bid.infra.messaging;

import com.pig_auction_service.bid.domain.entities.Bid;
import com.pig_auction_service.bid.infra.controllers.BidDTO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.CorrelationDataPostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;

import static org.apache.commons.lang.SerializationUtils.serialize;

@Component
public class BidProducer {

    @Value("${broker.exchange}")
    private String exchange;

    @Value("${broker.queue}")
    private String queue;

    @Value("${broker.routingKey}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    private final BidStatusListener bidStatusListener;

    public BidProducer(RabbitTemplate rabbitTemplate, BidStatusListener bidStatusListener) {
        this.rabbitTemplate = rabbitTemplate;
        this.bidStatusListener = bidStatusListener;
    }


//    @Value("${bidstatus.exchange}")
//    private String STATUS_EXCHANGE;
//    @Value("${bidstatus.routingKey}")
//    private String STATUS_ROUTING_KEY;
//    @Value("${bidstatus.queue}")
//    private String STATUS_QUEUE;

    public void publishBid(Bid domain) {

        BidDTO dto = new BidDTO(domain.getBidderId(), domain.getAuctionId(), domain.getValue(), domain.getTimestamp(), domain.getPublicId(), domain.isSuccess());

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        String correlationId = UUID.randomUUID().toString();
        messageProperties.setCorrelationId(correlationId);

        MessageConverter messageConverter = rabbitTemplate.getMessageConverter();
        Message message = messageConverter.toMessage(dto, messageProperties);


        rabbitTemplate.send(exchange, routingKey, message);


    }




}
