package com.google.play.entity;

public class MovieBuilder {
	
	private Movie movie=null;
	
	
	
	private MovieBuilder() {
		
	}
	
	public static MovieBuilder getMovie() {
		MovieBuilder movieBuilder=new MovieBuilder();
		movieBuilder.movie=new Movie();
		movieBuilder.movie.setName("Matrix");
		movieBuilder.movie.setNetPrice(10.0);
		movieBuilder.movie.setStock(10);
		
		return movieBuilder;
	}
	
	public Movie now() {
		return movie;
	}
	
	public static MovieBuilder noStock() {
		MovieBuilder movieBuilder=new MovieBuilder();
		movieBuilder.movie=new Movie();
		movieBuilder.movie.setName("Matrix");
		movieBuilder.movie.setNetPrice(10.0);
		movieBuilder.movie.setStock(0);
		
		return movieBuilder;
	}
	
	

}
