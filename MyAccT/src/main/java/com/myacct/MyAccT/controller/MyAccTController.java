package com.myacct.MyAccT.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myacct.MyAccT.entity.Application;
import com.myacct.MyAccT.entity.Customer;
import com.myacct.MyAccT.entity.Tracker;
import com.myacct.MyAccT.entity.TypeOfSubscription;
import com.myacct.MyAccT.service.MyAccTService;

@RestController
public class MyAccTController {

	@Autowired
	MyAccTService myacctservice;
	
	@GetMapping("/")
	public String home() {
		return "My HOME";
	}
	
	@CrossOrigin
	@PostMapping(path="/validate_user", produces=MediaType.APPLICATION_JSON_VALUE)
	Customer validate(@RequestBody Customer customer) {
		Customer validatedCustomer = myacctservice.validateCustomer(customer.getMailId(), customer.getPassword());
		System.out.println(validatedCustomer);
		return validatedCustomer;
	}
	
	@CrossOrigin
	@PostMapping(path="/forgot_password", produces=MediaType.APPLICATION_JSON_VALUE)
	Customer forgotPassword(@RequestBody Customer customer) {
		Customer duplicateData = myacctservice.checkForDuplicate(customer.getMailId());
		if(duplicateData.isLoginResult()) {
			//TODO: need to implement mailing password 
		}
		return duplicateData;
	}
	
	@CrossOrigin
	@PostMapping(path="/register_user", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Customer registerUser(@RequestBody Customer customerData) {
		Customer duplicateData = myacctservice.checkForDuplicate(customerData.getMailId());
		Customer registeredCustomer = new Customer();
		if(duplicateData.isLoginResult()) {
			registeredCustomer.setLoginResult(true);
		} else {
			registeredCustomer = myacctservice.registerCustomer(customerData);
			registeredCustomer.setLoginResult(false);
		}
		return registeredCustomer;			
	}
	
	@CrossOrigin
	@PostMapping(path="/get_list_of_tracker", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Tracker> getListOfTracker(@RequestBody Customer customerData) {
		return myacctservice.getAllTrackerDataByMailId(customerData.getMailId());
	}
	
	
	@CrossOrigin
	@PostMapping(path="/get_app_list", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Application> getAppList() {
		return myacctservice.getAppList();
	}
	
	@CrossOrigin
	@PostMapping(path="/get_type_list", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	List<TypeOfSubscription> getTypeList() {
		return myacctservice.getTypeList();
	}
	
	@CrossOrigin
	@PostMapping(path="/sample")
	@ResponseBody
	String sample() throws JsonProcessingException {
		ObjectMapper obj = new ObjectMapper();
		obj.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		List<Map<String,Object>> sampleList = new ArrayList<>();
		Map<String,Object> innerMap = new HashMap();
		List<innerObj> innerList = new ArrayList();
		innerObj i1 = new innerObj();
		i1.question = "What is the MetLife Preferred Dentist Program?";
		i1.answer = "MetList's Preferred Provider";

		innerObj i2 = new innerObj();
		i2.question = "What is MetLife Preferred Dentist Program?";
		i2.answer = "MetLife's Preferred Provider Organization(PPO)";
		innerList.add(i1);
		innerList.add(i2);
		
		innerMap.put("catName", "General Insurance");
		innerMap.put("qaSet", innerList);
		
		sampleList.add(innerMap);
		System.out.println(sampleList.toString());
		return obj.writeValueAsString(sampleList);
	}
}

class innerObj{
	String question;
	String answer;
	
	@Override
	public String toString() {
		return super.toString();
	}
}