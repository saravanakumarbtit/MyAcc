package com.myacct.MyAccT.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.myacct.MyAccT.entity.Customer;
import com.myacct.MyAccT.entity.Tracker;

public class TrackerCustomRepositoryImpl implements TrackerCustomRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Tracker> getAllDataUsingMailId(String mailId) {
		Query query = entityManager.createNativeQuery("select * from tracker where mail_id like ?",Tracker.class);
		query.setParameter(1, mailId);
		List<Tracker> resultList = new ArrayList<Tracker>();
		try {
			resultList = query.getResultList();
		}catch(NoResultException exp) {
			System.out.println("No data in db for the given mail id"+exp);
		}
		return resultList;
	}
	
}
