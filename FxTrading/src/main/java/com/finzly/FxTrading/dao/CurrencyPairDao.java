package com.finzly.FxTrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.finzly.FxTrading.entity.CurrencyPairEntity;


@Repository
public class CurrencyPairDao {
	@Autowired
	private SessionFactory factory;

	public String addcurrency(CurrencyPairEntity currencypair) {
		Session session = factory.openSession();
		session.save(currencypair);
		session.beginTransaction().commit();
		return "CurrencyPair Added Successfully";
	}
	
	public List<CurrencyPairEntity> getallCurrency() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPairEntity.class);
		return criteria.list();	
	}

	public List<CurrencyPairEntity> getallcurrency() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPairEntity.class);
		return criteria.list();	
	}

	public String getupdate(int id, CurrencyPairEntity currencypair) {	
		try (Session session = factory.openSession()) {
	        CurrencyPairEntity currencypairentity = session.get(CurrencyPairEntity.class, id);
	        if (currencypairentity != null) {
	        	Criteria criteria = session.createCriteria(CurrencyPairEntity.class);
	    		criteria .add(Restrictions.eq("currencyname",currencypair.getCurrencyname().toLowerCase() ));
	        	currencypairentity.setCurrencyvalue(currencypair.getCurrencyvalue());
	            session.update(currencypairentity);
	            session.beginTransaction().commit();
	            return "Currency pair updated successfully";
	        } else {
	            return "Currency pair with ID " + id + " not found";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error updating currency pair: " + e.getMessage();
	    }
	}

	public String getdeletecurrency(int id, CurrencyPairEntity currencypair) {
		Session session = factory.openSession();
		CurrencyPairEntity currencypairentity = session.get(CurrencyPairEntity.class,id);
		session.delete(currencypairentity);
		session.beginTransaction().commit();
		return "Currency deleted successfully";	
	}

}
