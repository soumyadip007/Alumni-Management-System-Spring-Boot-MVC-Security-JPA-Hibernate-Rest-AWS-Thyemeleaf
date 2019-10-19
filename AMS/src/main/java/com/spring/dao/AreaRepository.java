package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Area;
import com.spring.entity.Pujo;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Repository("areaRepository")
public interface AreaRepository extends JpaRepository<Area, Integer> {

	List<Area> findByDivision(String div);

	List<Area> findBySub(String sub);
	
}