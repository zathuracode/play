package com.google.play.service;

import static com.google.play.entity.UserBuilder.getUser;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.google.play.collaborator.CentralRisk;
import com.google.play.dao.BillDAO;
import com.google.play.entity.Bill;
import com.google.play.entity.Movie;
import com.google.play.entity.User;

public class MovieServiceDiscountTest {

	private List<Movie> movies;
	MovieService movieService=null;
	
	private CentralRisk centralRisk=null;
	private BillDAO billDAO=null;
	private UserService userService;
	private EmailService emailService;
	
	@Before
	public void setUp() throws Exception {
		
		movies=new ArrayList<>();
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
	
		
	@Test
	public void shouldDiscount50PercentMore3Movies()throws Exception {
		
		//Arrange
		double expected =20.0;
		User user=getUser().now();
		Movie movieOne=new Movie("Matrix"		,5,10.0);
		Movie movieTwo=new Movie("Matrix Reload",5,10.0);
		Movie movieThree=new Movie("Matrix Revolution",5,10.0);
		Movie movieFour=new Movie("Terminator",5,10.0);
		
		movies.add(movieOne);
		movies.add(movieTwo);
		movies.add(movieThree);
		movies.add(movieFour);
		
		Bill bill;
		
		//Act
		bill=movieService.rentMovie(user, movies);
		
		
		//Assert
		assertEquals(expected, bill.getNetPrice(),0.1);
		
		
	}
	
	
}
