package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entity.AMS;


/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Repository("amsRepository")
public interface AMSRepository extends JpaRepository<AMS, Integer> {

	List<AMS> findByYear(String div);

	List<AMS> findByDept(String div);
	
	List<AMS> findByCourse(String div);
	
	AMS findByEnrl(String div);
	
//	List<AMS> findByArea(String area);
	
	//@Query(value="select distinct division from pujo")
	//List<Pujo>  findDistinctById(String id);

}