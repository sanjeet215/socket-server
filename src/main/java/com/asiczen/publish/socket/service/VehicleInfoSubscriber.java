package com.asiczen.publish.socket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.asiczen.publish.socket.model.ConvertedMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VehicleInfoSubscriber implements MessageListener {

	@Autowired
	SimpMessagingTemplate messageTemplate;

	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void onMessage(Message message, byte[] pattern) {
		log.trace("Received >> " + message + ", " + Thread.currentThread().getName());

		try {

			ConvertedMessage cmesage = objectMapper.readValue(message.toString(), ConvertedMessage.class);
			this.messageTemplate.convertAndSend("/topic/asiczen", cmesage);
			log.trace("Message converted and published successfully.");
		} catch (Exception ep) {
			log.error("Error while conveting and meesage");
			log.error(ep.getLocalizedMessage());
		}

	}

}
