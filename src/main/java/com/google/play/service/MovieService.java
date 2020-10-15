package com.google.play.service;

import com.google.play.entity.Movie;
import com.google.play.entity.User;

public class MovieService {
	
	public void rentMovie(User user,Movie movie)throws Exception {
		if(user==null) {
			throw new Exception("User null");
		}
		
		if(movie==null) {
			throw new Exception("Movie null");
		}
		
		if(movie.getStock()==0) {
			throw new Exception("Not Stock Movie");
		}
	}
	
}
