package com.spring.service;

import java.util.List;
import com.spring.entity.Pujo;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
public interface PujoServiceInterface {

	public List<Pujo> findAll();

	public List<Pujo> findByDivision(String div);
	
	public void save(Pujo pujo);

	public Pujo findById(int theId); 

	public void deleteById(int theId);

	public List<Pujo> findByArea(String area);
}
