package com.google.play.service;

import java.util.ArrayList;
import java.util.List;

import com.google.play.collaborator.CentralRisk;
import com.google.play.dao.BillDAO;
import com.google.play.entity.Bill;
import com.google.play.entity.Movie;
import com.google.play.entity.User;

public class MovieService {
	
	private static List<Movie> movies=new ArrayList<>();
	
	private BillDAO billDao;
	private CentralRisk centralRisk;	
	private UserService userService;
	private EmailService emailService;
	private BillService billService;
	

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public void setCentralRisk(CentralRisk centralRisk) {
		this.centralRisk = centralRisk;
	}

	public void setBillDao(BillDAO billDAO) {
		this.billDao = billDAO;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setBillService(BillService billService) {
		this.billService = billService;
	}



	static {
		
		movies.add(new Movie("Matrix", 10));
		movies.add(new Movie("Matrix Reload", 0));
		movies.add(new Movie("Matrix Revolution", 1));
		movies.add(new Movie("Terminator", 1));
		
	}
	
	public Bill rentMovie(User user,List<Movie> movies)throws Exception {
		if(user==null) {
			throw new Exception("User null");
		}
		
		if(movies==null) {
			throw new Exception("Movie null");
		}
		
		if(movies.isEmpty()) {
			throw new Exception("Not Movies");
		}
		
		for (Movie movie : movies) {
			if(movies.contains(movie)==false) {
				throw new Exception("Movie no exists");
			}
			if(movie.getStock()==0) {
				throw new Exception("Movie no stock");
			}
		}
		
		if(centralRisk.getRiskByCustomer(user.getTypeDcoument(), user.getNumDocument())) {
			throw new Exception("High Risk Customer");
		}
		
		Bill bill=new Bill();
		
		double discount=0.0;
		double netPrice=0.0;
		double grossPrice=0.0;
		
		for (Movie movie : movies) {
			grossPrice=grossPrice+movie.getNetPrice();
		}
		
		if(movies.size()==2) {
			discount=grossPrice*0.20;
		}
		
		if(movies.size()==3) {
			discount=grossPrice*0.30;
		}
		
		if(movies.size()>3) {
			discount=grossPrice*0.50;
		}
		
		netPrice=grossPrice-discount;
		
		bill.setNetPrice(netPrice);
		
		//
		
		billDao.save(bill);
		
		return bill;
	}
	
	public void notifyNewMovies() {
		List<User> users=userService.getAll();
		List<Movie> newMovies=getNewMovies();
		
		users.forEach(user->{
			emailService.sendEmail(user,newMovies);
		});
		
		
	}

	public List<Movie> getNewMovies() {
		List<Movie> newMovies=new ArrayList<>();
		newMovies.add(new Movie("Matrix", 10,10.0));
		newMovies.add(new Movie("Matrix", 10,10.0));
		newMovies.add(new Movie("Matrix", 10,10.0));
		return newMovies;
	}
	
	public void refoundMoney(Bill bill) {
		Bill billRefound=new Bill();
		billRefound.setNetPrice(bill.getNetPrice());
		billRefound.setNumMovie(bill.getNumMovie());
		billRefound.setNumBill(919191);
		
		
		billService.refoundMoney(billRefound);	
	}
	
}
