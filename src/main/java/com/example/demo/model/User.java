package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;

	public User() {

	}

	public User(String username, String phone, String email) {
		this.username = username;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public void createUser(String username, String phone, String email) {
		this.username = username;
		this.phone = phone;
		this.email = email;
	}
	public void createUser(String username, String phone) {
		this.username = username;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}
}
