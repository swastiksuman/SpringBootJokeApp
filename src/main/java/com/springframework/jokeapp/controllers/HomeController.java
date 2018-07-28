package com.springframework.jokeapp.controllers;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.jokeapp.services.JokeService;

@Controller
public class HomeController {
	
	@Autowired
	JokeService jokeService;
	
	@RequestMapping("/")
	public String getHomePage(Model model) {
		Thread.currentThread().setName("joke thread");
		model.addAttribute("jokes", jokeService.getJokes());
		return "chucknorris";
	}
	
	@RequestMapping("/joke")
	public String getJokePage(Model model){
		model.addAttribute("joke", jokeService.getJoke());
		System.out.println(jokeService.getJoke());
		return "chucknorrisjoke";
	}
	
}
