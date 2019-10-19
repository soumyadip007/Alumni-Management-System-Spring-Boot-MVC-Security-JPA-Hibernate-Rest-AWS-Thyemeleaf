package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Res;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 * 
 */
@Repository("resRepository")
public interface ResRepository extends JpaRepository<Res, Integer> {

	List<Res> findByDivision(String div);

	List<Res> findByArea(String area);

}