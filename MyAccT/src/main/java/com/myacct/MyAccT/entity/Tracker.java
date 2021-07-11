package com.myacct.MyAccT.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Tracker implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false,updatable = false)
	Long id;
	
	@Column(name = "mail_id")
	String mailId;
	
	@OneToOne
	@JoinColumn(name = "app_id")
	Application appId;
	
	@OneToOne
	@JoinColumn(name="type_id")
	TypeOfSubscription typeOfSubscribtion;
	
	@Column(name = "from_date")
	LocalDate fromDate;
	
	@Column(name = "to_date")
	LocalDate toDate;
}
