package com.spring.service;

import java.util.List;

import com.spring.entity.Res;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
public interface ResServiceInterface {

	public List<Res> findAll();

	public List<Res> findByDivision(String div);
	
	public List<Res> findByArea(String div);
	
	public void save(Res res);

	public Res findById(int theId); 

	public void deleteById(int theId);
}
