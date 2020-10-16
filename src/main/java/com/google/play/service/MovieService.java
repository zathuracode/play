package com.google.play.service;

import java.util.ArrayList;
import java.util.List;

import com.google.play.entity.Movie;
import com.google.play.entity.User;

public class MovieService {
	
	private static List<Movie> movies=new ArrayList<>();
	
	static {
		movies.add(new Movie("Matrix", 4));
		movies.add(new Movie("Matrix Reload", 0));
		movies.add(new Movie("Matrix Revolution", 1));
		
	}
	
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
		
		if(movies.contains(movie)==false) {
			throw new Exception("Movie no exists");
		}
	}
	
}
