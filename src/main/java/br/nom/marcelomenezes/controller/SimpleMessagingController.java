package br.nom.marcelomenezes.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.nom.marcelomenezes.model.Message;
import br.nom.marcelomenezes.model.Reply;
import br.nom.marcelomenezes.service.SimpleMessagingService;

/**
 * Controller to exposes the following API:
 * 		GET /healthcheck - is server up?
 *		GET /message - receive any anonymous message in topic
 *		PUT /message - sends a message to topic
 *
 * - counter variable stores interactions only for log proporses
 * - class SimpleMessagingService handles the business logic to
 * send message and read message
 * 
 */

@RestController
public class SimpleMessagingController {

	private final AtomicLong counter = new AtomicLong();
		
	@GetMapping("/healthcheck")
	public Reply healthcheck() {
		return new Reply();
	}
	
	@PutMapping("/message")
	public Reply putMessage(@RequestBody Message message) {
		SimpleMessagingService.sendMessage(message);
		return new Reply(counter.incrementAndGet(), "OK");
	}
	
	@GetMapping("/message")
	public Reply getMessage() {
		return new Reply(counter.incrementAndGet(), SimpleMessagingService.readMessage());
	}
}
