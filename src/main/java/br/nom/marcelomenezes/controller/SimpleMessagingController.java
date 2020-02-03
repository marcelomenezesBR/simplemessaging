package br.nom.marcelomenezes.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.nom.marcelomenezes.model.Message;
import br.nom.marcelomenezes.model.Reply;
import br.nom.marcelomenezes.service.SimpleMessagingService;

@RestController
public class SimpleMessagingController {

	private final AtomicLong counter = new AtomicLong();
		
	@GetMapping("/healthcheck")
	public Reply healthcheck() {
		return new Reply();
	}
	
	@GetMapping("/heartbeat")
	public Reply heartbeat(){
		return new Reply(-1,counter.toString());
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
