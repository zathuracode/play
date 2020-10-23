package com.google.play.service;

import static com.google.play.entity.MovieBuilder.getMovie;
import static com.google.play.entity.UserBuilder.getUser;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import com.google.play.collaborator.CentralRisk;
import com.google.play.dao.BillDAO;
import com.google.play.entity.Bill;
import com.google.play.entity.Movie;
import com.google.play.entity.User;

@RunWith(Parameterized.class)
public class MovieServiceDiscountParameterizedTest {

	@Parameter(value = 0)	
	public List<Movie> 	movies	;
	
	@Parameter(value = 1)
	public double 		expected;
	
	@Parameter(value = 2)
	public String 		nameTest;


	MovieService movieService=null;
	
	private CentralRisk centralRisk=null;
	private BillDAO billDAO=null;
	private UserService userService;
	private EmailService emailService;
	
	@Before
	public void setUp() throws Exception {		
		
		movieService=new MovieService();
		
		billDAO= Mockito.mock(BillDAO.class);
		movieService.setBillDao(billDAO);
		
		centralRisk=Mockito.mock(CentralRisk.class);
		movieService.setCentralRisk(centralRisk);
		
		userService=Mockito.mock(UserService.class);
		movieService.setUserService(userService);
		
		emailService=Mockito.mock(EmailService.class);
		movieService.setEmailService(emailService);
		
	}


	private static Movie	movie1Interestellar 	= getMovie().now();
	private static Movie	movie2Insepction 		= getMovie().now();
	private static Movie	movie3TheWalkingDead 	= getMovie().now();
	private static Movie	movie4TheWitcher 		= getMovie().now();
	
	
	@Parameters(name = "{2}")
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
			{Arrays.asList(movie1Interestellar,movie2Insepction),16.0, "2 movies 20% Discount"},
			{Arrays.asList(movie1Interestellar,movie2Insepction,movie3TheWalkingDead),21.0, "3 movies 30% Discount"},
			{Arrays.asList(movie1Interestellar,movie2Insepction,movie3TheWalkingDead,movie4TheWitcher),20.0,"More That 3 Movies 50% Percent"	}
			
		});
		
	}
	
	
	@Test
	public void shouldDiscountPercentMore1Movies() throws Exception {
		//Arrange 
		User 	user 					= getUser().now();
		Bill	bill;
		
		//Act
		bill = movieService.rentMovie(user, movies);
		
		//Assert
		Assert.assertEquals(expected, bill.getNetPrice(),0.1);
		
	}
	
	
}
