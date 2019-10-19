package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.AreaRepository;
import com.spring.entity.Area;
import com.spring.entity.Pujo;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Service
public class AreaService implements AreaServiceInterface {

	
	private AreaRepository areaRepository;
	

	@Autowired   
	public AreaService(AreaRepository obj)
	{
		areaRepository=obj;
	}
	
	
	@Override
	public List<Area> findAll() {
	
		return areaRepository.findAll();
	}

	@Override
	public void save(Area area) {
		
		areaRepository.save(area);
	}


	@Override
	public void deleteById(int theId) {
		areaRepository.deleteById(theId);
	}


	@Override
	public List<Area> findByDivision(String div) {

		return areaRepository.findByDivision(div);
	}


	@Override
	public List<Area> findBySub(String area) {
		
		return areaRepository.findBySub(area);
	}


	@Override
	public Area findById(int id) {

		Optional<Area> result=areaRepository.findById(id);
		
		Area area=null;
		
		if(result.isPresent())
		{
			area=result.get();
		}
		else {
			throw new RuntimeException("Did not find area id - " + id);
		}
		return  area;	
		}



}
