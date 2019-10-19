package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entity.Pujo;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Repository("pujoRepository")
public interface PujoRepository extends JpaRepository<Pujo, Integer> {

	List<Pujo> findByDivision(String div);

	
	List<Pujo> findByArea(String area);
	
	//@Query(value="select distinct division from pujo")
	//List<Pujo>  findDistinctById(String id);

}