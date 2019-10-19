package com.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.AMSRepository;
import com.spring.entity.AMS;

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
	public List<AMS> findAll() {
	
		return pujoRepository.findAll();
	}

	@Override
	public void save(AMS pujo) {
		
		pujoRepository.save(pujo);
	}

	@Override
	public AMS findById(int theId) {
		
		Optional<AMS> result=pujoRepository.findById(theId);
		
		AMS pujo=null;
		
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
	public List<AMS> findByDivision(String div) {
	
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
	public List<AMS> findByArea(String area) {
		
		return pujoRepository.findByArea(area);
	}

}
