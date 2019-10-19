package com.spring.service;

import java.util.List;
import com.spring.entity.AMS;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
public interface AMSServiceInterface {

	public List<AMS> findAll();

	public void save(AMS ams);

	public AMS findById(int theId); 

	public void deleteById(int theId);
	
	public List<AMS> findByYear(String div);

	public List<AMS> findByDept(String div);
	
	public List<AMS> findByCourse(String div);
	
	public List<AMS> findByEnrl(String div);
	

}
