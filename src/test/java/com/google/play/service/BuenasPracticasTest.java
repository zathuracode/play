package com.google.play.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import com.google.play.entity.Movie;
import com.google.play.entity.User;



public class BuenasPracticasTest {
//	
//	@Rule
//	public ErrorCollector error = new ErrorCollector();
//	
//	@Rule
//	public ExpectedException exception = ExpectedException.none();
//	
//
//	@Test
//	public void test() {
//		//Arrange
//		int precio=0;
//		Integer precio2=0;
//		Double precio3=0.05;
//		double precio4=0.005;
//		
//		User user1=new User("Diego");
//		User user2=new User("Diego");
//		//Act
//		
//		//Assert
//		
//		//assertEquals(precio, precio2);
//		assertEquals(precio3, precio4,0.2);
//		assertEquals(Math.PI, 3.14,0.2);
//		assertEquals("Boy","Boy");
//		assertEquals(user1,user2);
//		assertSame(user1, user1);		
//			
//	}
//	
//	@Test
//	public void shouldRentMovieWeekend() throws Exception {
//		//Arrange
//			Calendar calendar=Calendar.getInstance();
//			calendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
//			DateFormat dateFormat=new SimpleDateFormat("EEE dd/MM/yyyy");
//		//Act
//			System.out.println(dateFormat.format(calendar.getTime()));
//			
//			boolean isWeekend=dateFormat.format(calendar.getTime()).contains("Sat");
//			
//			//Se salta la prueba si es false y notifica que se la salto
//			Assume.assumeFalse(isWeekend);
//		//Assert
//			
//			int precio=5;
//			Integer precio2=10;
//			
//			assertEquals(precio, precio2.intValue());
//	}
//	
//	@Test
//	public void noShouldRentMovie() throws Exception {
//		//Arrange
//		User user=new User("Diego");
//		Movie movie=new Movie("matrix", 0);
//		
//		//Act
//		
//		exception.expect(Exception.class);
//		exception.expectMessage("Not Stock Movie");
//		MovieService movieService=new MovieService();
//		movieService.rentMovie(user, movie);
//		
//		//Assert
//		
//	}
//	
//	@Test
//	public void noShouldRentMovie2() {
//		//Arrange
//		User user=new User("Diego");
//		Movie movie=new Movie("matrix", 0);
//
//	
//		//Act
//		
//		MovieService movieService=new MovieService();
//		try {
//			movieService.rentMovie(user, movie);
//			
//			//Assert
//			Assert.fail("Se esperaba una exception");
//			
//		} catch (Exception e) {
//			error.checkThat(e.getMessage(), is("Not Stock Movie"));
//		}		
//	}
//	
//	@Test(expected = Exception.class)
//	public void noShouldRentMovie3()throws Exception {
//		//Arrange
//		User user=new User("Diego");
//		Movie movie=new Movie("matrix", 0);
//		
//		//Act
//		
//		MovieService movieService=new MovieService();
//		movieService.rentMovie(user, movie);
//						
//	}
//	
//	@Test()
//	public void shouldRentMovie()throws Exception {
//		//Arrange
//		User user=new User("Diego");
//		Movie movie=new Movie("Matrix", 1);
//		
//		//Act
//		
//		MovieService movieService=new MovieService();
//		movieService.rentMovie(user, movie);
//						
//	}

}
