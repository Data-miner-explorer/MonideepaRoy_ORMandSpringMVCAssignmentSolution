package com.greatlearning.CRMapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Repository
public class CustomersServiceImpl implements CustomersService {
	private SessionFactory sessionFactory;
	private Session session;

	// 	Using Autowired in constructor-based DI is optional in latest Spring
	@Autowired
	CustomersServiceImpl( SessionFactory sessionFactory ) {
	    this.sessionFactory = sessionFactory;
		
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = this.sessionFactory.openSession();
		}
	}

	@Transactional
	public List<customers> findAll() {
		// Note: If Entity name is specified then use it instead of table name - eg. "from Pustak"
//		Transaction tx = session.beginTransaction();
		List<customers> customers = session.createQuery( "from customers", customers.class ).list(); // find all the records from the database table
//		tx.commit();

		return customers;
	}

	@Transactional
	public customers findById( int id ) {
		customers customers = new customers();

		Transaction tx = session.beginTransaction();
		customers = session.get(customers.class, id);
		tx.commit();

		return customers;
	}

	@Transactional
	public void save( customers customers ) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate( customers );
		tx.commit();
	}

	@Transactional
	public void deleteById( int id ) {
		Transaction tx = session.beginTransaction();
		customers customers = session.get(customers.class, id);
		session.delete( customers );
		tx.commit();
	}

	@Transactional
	public void print( List<customers> customers ) {
		for( customers c : customers ) {
			System.out.println( c );
		}
	}
}
