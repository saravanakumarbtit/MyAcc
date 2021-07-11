package com.myacct.MyAccT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myacct.MyAccT.entity.Application;
import com.myacct.MyAccT.entity.Customer;
import com.myacct.MyAccT.entity.Tracker;
import com.myacct.MyAccT.entity.TypeOfSubscription;
import com.myacct.MyAccT.repository.ApplicationRepository;
import com.myacct.MyAccT.repository.CustomerRepository;
import com.myacct.MyAccT.repository.TrackerRepository;
import com.myacct.MyAccT.repository.TypeOfSubscriptionRepository;

public class MyAccTServiceImpl implements MyAccTService{

	@Autowired
	CustomerRepository customerrepository;
	
	@Autowired
	TrackerRepository trackerrepository;
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	TypeOfSubscriptionRepository typeRepository;
	
	@Override
	public Customer validateCustomer(String email, String password) {
		Customer data = customerrepository.getDataUsingMailId(email);
		if(data.isLoginResult() && data.getPassword().equals(password)) {
			data.setPassword("Ha Ha, Better luck next time");
		}
		return data;
	}

	@Override
	public Customer registerCustomer(Customer customerData) {
		customerrepository.save(customerData);
		return customerData;
	}

	@Override
	public Customer checkForDuplicate(String mailId) {
		return customerrepository.getDataUsingMailId(mailId);
	}

	@Override
	public List<Tracker> getAllTrackerDataByMailId(String mailId) {
		return trackerrepository.getAllDataUsingMailId(mailId);	
	}

	@Override
	public List<Application> getAppList() {
		return applicationRepository.findAll();
	}

	@Override
	public List<TypeOfSubscription> getTypeList() {
		return typeRepository.findAll();
	}

}
