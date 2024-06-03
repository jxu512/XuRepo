// Standalone web client

package com.example.reactivewebservice;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class GreetingClient1 {

	private final WebClient client;

	public GreetingClient1() {
		WebClient.Builder builder = WebClient.builder();
		this.client = builder.baseUrl("http://localhost:8080").build();
	}

	public Mono<String> getMessage() {
		return this.client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Greeting.class)
				.map(Greeting::getMessage)
				;
	}

	public static void main(String[] args) {

		GreetingClient1 greetingClient1 = new GreetingClient1();
		Mono response = greetingClient1.getMessage();
		// Subscribe asynchroniously
		response.subscribe(msg->System.out.println("Subscribe asynchronously: " + msg));
		// Block and wait for response
		System.out.println("Block until message arrives: " + response.block());
	}
}
