package com.example.userregisteration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	private @GeneratedValue long id;
	@Id
	private String username;
	@Id
	private String password;
	@Id
	private  boolean loggedIn;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.loggedIn = false;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\''
				+ ", loggedIn=" + loggedIn + '}';
	}
}