package com.finzly.FxTrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.finzly.FxTrading.entity.CurrencyPairEntity;
import com.finzly.FxTrading.entity.TradeEntity;

@Repository
public class TradeDao {
	@Autowired
	private SessionFactory factory;
	
	public void addtrade(TradeEntity tradeentity) {
		Session session = factory.openSession();
		session.save(tradeentity);
		session.beginTransaction().commit();
		session.close();
	}
	
	public List<TradeEntity> ahowalltrade() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(TradeEntity.class);
		return criteria.list();
	}
}
