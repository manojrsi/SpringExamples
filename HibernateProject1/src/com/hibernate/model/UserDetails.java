package com.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "UserDetail"  )
@Table(name= "UserDetail")
public class UserDetails {
	
	@Id
	//@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@GeneratedValue
	@Column(name = "user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Lob
	private String description;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", date=" + date + ", description="
				+ description + "]";
	}

}
