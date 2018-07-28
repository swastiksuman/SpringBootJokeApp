package com.springframework.jokeapp.services;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.springframework.jokeapp.repositories.JokeRepository;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import reactor.core.publisher.Flux;

@Service
public class JokeService {

	@Autowired
	private JokeRepository jokeRepository;

	private ChuckNorrisQuotes chuckNorrisQuotes;

	public JokeService() {
		System.out.println("Joke Service Constructor Called");
		chuckNorrisQuotes = new ChuckNorrisQuotes();
	}

	public List<String> getJokes() {
		System.out.println("Service" + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
		return jokeRepository.getAllJokes();
	}

	public String getJoke() {
		return chuckNorrisQuotes.getRandomQuote();
	}

	@Async
	public CompletableFuture<String> findUser() throws InterruptedException {
		Thread.sleep(5000L);
		return CompletableFuture.completedFuture("Hi");
	}

	public Flux<String> streamRandomJokes() {
		Flux<String> fluxOfJokes = Flux.just("A","B","C","D","E","F","G","H","I");
		return fluxOfJokes;
	}
}
