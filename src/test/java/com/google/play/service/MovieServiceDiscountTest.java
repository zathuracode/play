package com.google.play.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.google.play.collaborator.CentralRisk;
import com.google.play.dao.BillDAO;
import com.google.play.entity.Bill;
import com.google.play.entity.Movie;
import com.google.play.entity.User;

public class MovieServiceDiscountTest {

private List<Movie> movies;
private CentralRisk centralRisk=null;
private BillDAO billDAO=null;
	
	@Before
	public void setUp() throws Exception {
		
		movies=new ArrayList<>();
		billDAO=Mockito.mock(BillDAO.class);
		centralRisk=Mockito.mock(CentralRisk.class);
		
	}
	
	MovieService movieService=new MovieService();
	
	
	
	@Test
	public void shouldDiscount50PercentMore3Movies()throws Exception {
		
		//Arrange
		double expected =20.0;
		User user=new User("dgomez");
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
