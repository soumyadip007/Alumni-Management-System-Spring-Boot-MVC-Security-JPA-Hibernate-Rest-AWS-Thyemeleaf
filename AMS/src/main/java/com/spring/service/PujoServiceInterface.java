package com.spring.service;

import java.util.List;
import com.spring.entity.AMS;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
public interface PujoServiceInterface {

	public List<AMS> findAll();

	public List<AMS> findByDivision(String div);
	
	public void save(AMS pujo);

	public AMS findById(int theId); 

	public void deleteById(int theId);

	public List<AMS> findByArea(String area);
}
