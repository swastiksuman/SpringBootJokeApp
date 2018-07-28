package com.springframework.jokeapp.controllers;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.jokeapp.services.JokeService;

import reactor.core.publisher.Flux;

@RestController
public class HomeRestController {

	@Autowired
	JokeService jokeService;

	@RequestMapping("/async")
	public String getAsyncData() throws InterruptedException, ExecutionException {
		return jokeService.findUser().get();
	}

	@GetMapping(path = "/j", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<String> randomJokesStreaming() {
		return jokeService.streamRandomJokes();
	}
}
