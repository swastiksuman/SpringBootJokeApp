package com.springframework.jokeapp.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JokeRepository {

	public List<String> getAllJokes() {
		List<String> jokes = new ArrayList<String>();
		jokes.add("An elephant and an ant...");
		jokes.add("A skeleton walks into a bar...");
		return jokes;
	}
}
