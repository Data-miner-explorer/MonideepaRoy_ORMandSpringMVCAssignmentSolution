package com.greatlearning.CRMapp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) {
    	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass( customers.class );
	    SessionFactory sessionFactory = con.buildSessionFactory();
        
	    CustomersService cs = new CustomersServiceImpl( sessionFactory );
        
        customers customers = new customers();
        
        customers.setFirstName( "Harshit" );
        customers.setLastName( "Choudhary" );
        customers.setEmail( "Harshit@greatlearning.in" );
        
        cs.save( customers );
        
        List<customers> customersl = cs.findAll();
		
		for( customers c : customersl ) {
			System.out.println( c );
		}
    }
}
