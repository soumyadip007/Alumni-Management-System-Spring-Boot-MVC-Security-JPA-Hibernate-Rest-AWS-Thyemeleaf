package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.ResRepository;
import com.spring.entity.Pujo;
import com.spring.entity.Res;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Service
public class ResService implements ResServiceInterface {

	
	private ResRepository resRepository;
	

	@Autowired   
	public ResService(ResRepository obj)
	{
		resRepository=obj;
	}
	
	
	@Override
	public List<Res> findAll() {
	
		return resRepository.findAll();
	}

	@Override
	public void save(Res res) {
		
		resRepository.save(res);
	}

	@Override
	public Res findById(int theId) {
		
		Optional<Res> result=resRepository.findById(theId);
		
		Res res=null;
		
		if(result.isPresent())
		{
			res=result.get();
		}
		else {
			throw new RuntimeException("Did not find res id - " + theId);
		}
		return  res;
	}


	@Override
	public void deleteById(int theId) {
		resRepository.deleteById(theId);
	}


	@Override
	public List<Res> findByDivision(String div) {
	
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
		
		return resRepository.findByDivision(div);
	}


	@Override
	public List<Res> findByArea(String area) {
		// TODO Auto-generated method stub
		return resRepository.findByArea(area);
	}

}
