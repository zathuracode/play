package com.google.play.entity;

public class UserBuilder {
	
	private User user=null;
	
	
	
	private UserBuilder() {
		
	}
	
	public static UserBuilder getUser() {
		UserBuilder userBuilder=new UserBuilder();
		userBuilder.user=new User("");
		userBuilder.user.setName("Diego");
		userBuilder.user.setNumDocument(14836554);
		userBuilder.user.setTypeDcoument("CC");
		
		return userBuilder;
	}
	
	public UserBuilder otherName(String name) {
		this.user.setName(name);
		return this;
	}
	
	public UserBuilder highRisk() {
		this.user.setNumDocument(31909777);
		return this;
	}
	
	public User now() {
		return user;
	}
	
	

}
