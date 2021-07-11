package com.myacct.MyAccT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myacct.MyAccT.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, String>{

}
