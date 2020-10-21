package com.google.play.entity;

public class User {

	private String name;
	private String typeDcoument;
	private Integer numDocument;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name) {
		super();
		this.name = name;
	}
	
	public String getTypeDcoument() {
		return typeDcoument;
	}

	public void setTypeDcoument(String typeDcoument) {
		this.typeDcoument = typeDcoument;
	}

	public Integer getNumDocument() {
		return numDocument;
	}

	public void setNumDocument(Integer numDocument) {
		this.numDocument = numDocument;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
