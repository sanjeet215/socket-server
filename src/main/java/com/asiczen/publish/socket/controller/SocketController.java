package com.asiczen.publish.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.asiczen.publish.socket.model.ConvertedMessage;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SocketController {

	@Autowired
	SimpMessagingTemplate messageTemplate;

	@MessageMapping("/orgmessage")
	@SendTo("/topic/asiczen")
	public ConvertedMessage getConvertedMessage(ConvertedMessage cmsg) throws InterruptedException {
		return cmsg;
	}
}
