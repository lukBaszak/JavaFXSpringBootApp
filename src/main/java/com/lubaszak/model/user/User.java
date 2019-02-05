package com.lubaszak.model.user;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	private String email;
	private String password;

	protected User() {
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() { return email; }
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() { return password; }
	public void setPassword(String password) {
		this.password = password;
	}

}




