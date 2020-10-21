package com.google.play.service;

import java.util.List;

import com.google.play.entity.Movie;
import com.google.play.entity.User;

public interface EmailService {
	
	public void sendEmail(User user,List<Movie> movies);
	
}
