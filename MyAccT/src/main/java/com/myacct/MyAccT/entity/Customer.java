package com.myacct.MyAccT.entity;


import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "serail_id")
	Long serailId;
	
	@Column(unique = true, name = "mail_id")
	String mailId;
	
	@Column(name = "user_name")
	String userName;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "phone_number")
	String phoneNumber;
	
	@Transient
	boolean loginResult;
}
