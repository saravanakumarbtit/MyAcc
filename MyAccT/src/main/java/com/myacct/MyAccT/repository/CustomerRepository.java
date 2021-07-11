package com.myacct.MyAccT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myacct.MyAccT.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>, CustomerCustomRepository{

}
