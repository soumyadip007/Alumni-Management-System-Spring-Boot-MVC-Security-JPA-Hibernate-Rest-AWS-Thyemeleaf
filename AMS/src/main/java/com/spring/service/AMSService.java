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
public class AMSService implements AMSServiceInterface {

	
	private AMSRepository amsRepository;
	

	@Autowired   
	public AMSService(AMSRepository obj)
	{
		amsRepository=obj;
	}
	
	
	@Override
	public List<AMS> findAll() {
	
		return amsRepository.findAll();
	}

	@Override
	public void save(AMS ams) {
		
		amsRepository.save(ams);
	}

	@Override
	public AMS findById(int theId) {
		
		Optional<AMS> result=amsRepository.findById(theId);
		
		AMS ams=null;
		
		if(result.isPresent())
		{
			ams=result.get();
		}
		else {
			throw new RuntimeException("Did not find ams id - " + theId);
		}
		return  ams;
	}


	@Override
	public void deleteById(int theId) {
		amsRepository.deleteById(theId);
	}


	@Override
	public List<AMS> findByYear(String div) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<AMS> findByDept(String div) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<AMS> findByCourse(String div) {
		
		return null;
	}

//
//	@Override
//	public List<AMS> findByDivision(String div) {
//	
////		Optional<ams> result=amsRepository.findByDivision(div);
////		
////		List<ams> ams=null;
////		
////		if(result.isPresent())
////		{
////			ams.add(result.get());
////		}
////		else {
////			throw new RuntimeException("Did not find ams div - " + div);
////		}
//		
//		return amsRepository.findByDivision(div);
//	}
//
//
//	@Override
//	public List<AMS> findByArea(String area) {
//		
//		return amsRepository.findByArea(area);
//	}

}
