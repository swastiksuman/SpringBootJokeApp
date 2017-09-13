package com.springframework.jokeapp.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springframework.jokeapp.repositories.JokeRepository;

@Service
public class JokeService {
	
	@Autowired
	private JokeRepository jokeRepository;
	
	private ChuckNorrisQuotes chuckNorrisQuotes;
	
	public JokeService(){
		chuckNorrisQuotes = new ChuckNorrisQuotes();
	}
	
	public List<String> getJokes(){
		return jokeRepository.getAllJokes();
	}
	
	public String getJoke(){
		return chuckNorrisQuotes.getRandomQuote();
	}
}
