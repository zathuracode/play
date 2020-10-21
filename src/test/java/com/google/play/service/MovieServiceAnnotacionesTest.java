package com.google.play.service;

import static  com.google.play.entity.MovieBuilder.getMovie;
import static  com.google.play.entity.MovieBuilder.noStock;
import static  com.google.play.entity.UserBuilder.getUser;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.google.play.collaborator.CentralRisk;
import com.google.play.dao.BillDAO;
import com.google.play.entity.Bill;
import com.google.play.entity.BillBuilder;
import com.google.play.entity.Movie;
import com.google.play.entity.User;

public class MovieServiceAnnotacionesTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private List<Movie> movies;
	
	@InjectMocks
	MovieService movieService;
	
	@Mock
	private CentralRisk centralRisk;
	@Mock
	private BillDAO billDAO;
	@Mock
	private UserService userService;
	@Mock
	private EmailService emailService;
	
	@Mock
	private BillService billService; 
	
	@Before
	public void setUp() throws Exception {
		
		movies=new ArrayList<>();
		movieService=new MovieService();
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void shouldNotifyNewMovies() {
		
		//Arrange
		List<User> users=new ArrayList<>();
		User userOne=getUser().now();
		User userTwo=getUser().otherName("Benito Camelas").now();
		User userThree=getUser().otherName("Elber Gomez").highRisk().now();
		
		users.add(userOne);
		users.add(userTwo);
		
		when(userService.getAll()).thenReturn(users);
		
		List<Movie> movies=new ArrayList<>();
		movies.add(getMovie().now());
		movies.add(getMovie().now());
		movies.add(getMovie().now());
		
		//Act
		movieService.notifyNewMovies();
		
		//Assert
		Mockito.verify(emailService).sendEmail(userOne,movies);
		Mockito.verify(emailService).sendEmail(userTwo,movies);
		Mockito.verify(emailService,Mockito.never()).sendEmail(userThree,movies);
		
	}
	
	@Test
	public void noShouldRentMovieHighRiskCustomer()throws Exception {
		
		//Arrange
		double expected =20.0;
		User user=getUser().highRisk().now();
		//User noRiskUser=getUser().now();
		Movie movie=getMovie().now();
		movies.add(movie);
		Bill bill;
		
		Mockito.when(centralRisk.getRiskByCustomer(user.getTypeDcoument(), user.getNumDocument()))
		.thenReturn(true);
		
		exception.expect(Exception.class);
		exception.expectMessage("High Risk Customer");
		
		//Act
		bill=movieService.rentMovie(user, movies);		
	}
	
	@Test
	public void noShouldRentMovieHighRiskCustomer2()throws Exception {
		
		//Arrange
		double expected =20.0;
		User user=getUser().highRisk().now();
		//User noRiskUser=getUser().now();
		Movie movie=getMovie().now();
		movies.add(movie);
		Bill bill;
		
		Mockito.when(centralRisk.getRiskByCustomer(user.getTypeDcoument(), user.getNumDocument()))
		.thenThrow(new Exception("High Risk Customer"));
		
		exception.expect(Exception.class);
		exception.expectMessage("High Risk Customer");
		
		//Act
		bill=movieService.rentMovie(user, movies);		
	}
	
	
	
	@Test(expected = Exception.class)
	public void noShouldRentMovieStockCero()throws Exception {
		//Arrange
		User user=getUser().now();
		Movie movie=noStock().now();
		movies.add(movie);
		//Act
		
		MovieService movieService=new MovieService();
		movieService.rentMovie(user, movies);
						
	}

	@Test
	public void shouldRentMovie() throws Exception {
		
		//Arrange
		double expected =10.0;
		User user=getUser().now();
		Movie movie=getMovie().now();
		movies.add(movie);
		Bill bill;
		
		//Act
		bill=movieService.rentMovie(user, movies);
		
		//Assert
		assertEquals(expected, bill.getNetPrice(),0.1);
		
		
	}
	
	@Test
	public void shouldDiscount20PercentBy2Movies()throws Exception {
		
		//Arrange
		double expected =16.0;
		User user=getUser().now();
		Movie movieOne=getMovie().now();
		Movie movieTwo=getMovie().now();
		movies.add(movieOne);
		movies.add(movieTwo);
		Bill bill;
		
		//Act
		bill=movieService.rentMovie(user, movies);
		
		//Assert
		assertEquals(expected, bill.getNetPrice(),0.1);
		
		
	}
	
	@Test
	public void shouldDiscount30PercentBy3Movies()throws Exception {
		
		//Arrange
		double expected =21.0;
		User user=getUser().now();
		Movie movieOne	=getMovie().now();
		Movie movieTwo	=getMovie().now();
		Movie movieThree=getMovie().now();
		
		movies.add(movieOne);
		movies.add(movieTwo);
		movies.add(movieThree);
		
		Bill bill;
		
		//Act
		bill=movieService.rentMovie(user, movies);
		
		//Assert
		assertEquals(expected, bill.getNetPrice(),0.1);		
	}
	
	@Test
	public void shouldDiscount50PercentMore3Movies()throws Exception {
		
		//Arrange
		double expected =20.0;
		User user=getUser().now();
		Movie movieOne=getMovie().now();
		Movie movieTwo=getMovie().now();
		Movie movieThree=getMovie().now();
		Movie movieFour=getMovie().now();
		
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
	
	@Test
	public void shouldRefoundMoney() {
		
		//Arrange
		double expected =20.0;
		Bill bill=BillBuilder.getBill().now();
		Bill billRefound=BillBuilder.getBill().otherNumBill(919191.0).now();
		
		
		//Act
		movieService.refoundMoney(bill);
		
		//Assert
		ArgumentCaptor<Bill> captor=ArgumentCaptor.forClass(Bill.class);
		Mockito.verify(billService).refoundMoney(captor.capture());
		
		Bill billRefoundCapture=captor.getValue();
		
		assertEquals(bill.getNetPrice(), billRefoundCapture.getNetPrice(),0.0);
		
		
			
	}

}
