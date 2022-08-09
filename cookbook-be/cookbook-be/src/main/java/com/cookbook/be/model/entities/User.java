package com.cookbook.be.model.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<UserFavorite> userFavList;
	
	public User() {
		super();
	}
	
	public User(String userName, String password, String userType) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public User(int userId, String userName, String password, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<UserFavorite> getUserList() {
		return userFavList;
	}

	public void setUserList(List<UserFavorite> userFavList) {
		this.userFavList = userFavList;
	}
}
