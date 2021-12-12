package com.greatlearning.CRMapp;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CustomersService { 
	public List<customers> findAll();
	public customers findById( int id );
	public void save( customers customers );
	public void deleteById( int id );
}