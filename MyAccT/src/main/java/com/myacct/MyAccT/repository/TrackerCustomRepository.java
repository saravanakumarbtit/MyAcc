package com.myacct.MyAccT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myacct.MyAccT.entity.Customer;
import com.myacct.MyAccT.entity.Tracker;

public interface TrackerCustomRepository{
	public List<Tracker> getAllDataUsingMailId(String mailId);
}
