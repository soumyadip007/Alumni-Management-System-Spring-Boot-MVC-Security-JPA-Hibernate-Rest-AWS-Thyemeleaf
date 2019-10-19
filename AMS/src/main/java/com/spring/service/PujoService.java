package com.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.AMSRepository;
import com.spring.entity.Pujo;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Service
public class PujoService implements PujoServiceInterface {

	
	private AMSRepository pujoRepository;
	

	@Autowired   
	public PujoService(AMSRepository obj)
	{
		pujoRepository=obj;
	}
	
	
	@Override
	public List<Pujo> findAll() {
	
		return pujoRepository.findAll();
	}

	@Override
	public void save(Pujo pujo) {
		
		pujoRepository.save(pujo);
	}

	@Override
	public Pujo findById(int theId) {
		
		Optional<Pujo> result=pujoRepository.findById(theId);
		
		Pujo pujo=null;
		
		if(result.isPresent())
		{
			pujo=result.get();
		}
		else {
			throw new RuntimeException("Did not find Pujo id - " + theId);
		}
		return  pujo;
	}


	@Override
	public void deleteById(int theId) {
		pujoRepository.deleteById(theId);
	}


	@Override
	public List<Pujo> findByDivision(String div) {
	
//		Optional<Pujo> result=pujoRepository.findByDivision(div);
//		
//		List<Pujo> pujo=null;
//		
//		if(result.isPresent())
//		{
//			pujo.add(result.get());
//		}
//		else {
//			throw new RuntimeException("Did not find Pujo div - " + div);
//		}
		
		return pujoRepository.findByDivision(div);
	}


	@Override
	public List<Pujo> findByArea(String area) {
		
		return pujoRepository.findByArea(area);
	}

}
