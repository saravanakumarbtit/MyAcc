package com.myacct.MyAccT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myacct.MyAccT.entity.Customer;
import com.myacct.MyAccT.entity.Tracker;

public interface TrackerRepository extends JpaRepository<Tracker, String>, TrackerCustomRepository{

}
