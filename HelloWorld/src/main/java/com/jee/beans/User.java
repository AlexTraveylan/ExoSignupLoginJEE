package com.jee.beans;

public class User {
	private final int id;
	private final String username;
	private final String email;
	private final String password;

	
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public static class Builder {
		//Required
		private final int id;
		private final String username;
		
		//optionnal
		private String email = "@";
		private String password = "1234";
		
		public Builder(int id, String username) {
			this.id = id;
			this.username = username;
		}
		
		public Builder email(String val) {
			email = val; 
			return this;
		}
		public Builder password(String val) {
			password = val; 
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	private User(Builder builder) {
		id = builder.id;
		username = builder.username;
		email = builder.email;
		password = builder.password;
	}
}
