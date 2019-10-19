package com.spring.service;

import java.util.List;

import com.spring.entity.Area;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
public interface AreaServiceInterface {

	public List<Area> findAll();

	public List<Area> findByDivision(String div);
	
	public Area findById(int id);
	
	public List<Area> findBySub(String area);
	
	public void save(Area area);

	public void deleteById(int theId);

}
