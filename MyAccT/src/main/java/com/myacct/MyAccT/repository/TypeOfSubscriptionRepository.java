package com.myacct.MyAccT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myacct.MyAccT.entity.Application;
import com.myacct.MyAccT.entity.TypeOfSubscription;

public interface TypeOfSubscriptionRepository extends JpaRepository<TypeOfSubscription, String>{

}
