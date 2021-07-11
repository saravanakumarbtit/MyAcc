package com.myacct.MyAccT.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.myacct.MyAccT.entity.Customer;

public class CustomerCustomRepositoryImpl implements CustomerCustomRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Customer getDataUsingMailId(String mailId) {
		Query query = entityManager.createNativeQuery("select * from customer where mail_id like ?",Customer.class);
		query.setParameter(1, mailId);
		Customer result = new Customer();
		try {
			result = (Customer) query.getSingleResult();
			result.setLoginResult(true);
		}catch(NoResultException exp) {
			result.setLoginResult(false);
			System.out.println("No data in db for the given mail id"+exp);
		}
		return result;
	}
	
}
