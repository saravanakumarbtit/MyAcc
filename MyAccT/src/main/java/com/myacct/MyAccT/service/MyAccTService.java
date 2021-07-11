package com.myacct.MyAccT.service;

import java.util.List;

import com.myacct.MyAccT.entity.Application;
import com.myacct.MyAccT.entity.Customer;
import com.myacct.MyAccT.entity.Tracker;
import com.myacct.MyAccT.entity.TypeOfSubscription;

public interface MyAccTService {

	public Customer validateCustomer(String email, String password);

	public Customer registerCustomer(Customer customerData);

	public Customer checkForDuplicate(String mailId);

	public List<Tracker> getAllTrackerDataByMailId(String mailId);

	public List<Application> getAppList();

	public List<TypeOfSubscription> getTypeList();
}
