package com.google.play.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.play.entity.User;

public class MovieServiceTest {

	@Test
	public void test() {
		//Arrange
		int precio=0;
		Integer precio2=0;
		Double precio3=0.05;
		double precio4=0.005;
		
		User user1=new User("Diego");
		User user2=new User("Diego");
		//Act
		
		//Assert
		
		//assertEquals(precio, precio2);
		assertEquals(precio3, precio4,0.2);
		assertEquals(Math.PI, 3.14,0.2);
		assertEquals("Boy","Boy");
		assertEquals(user1,user2);
		assertSame(user1, user1);
			
			
			
		
	}

}
