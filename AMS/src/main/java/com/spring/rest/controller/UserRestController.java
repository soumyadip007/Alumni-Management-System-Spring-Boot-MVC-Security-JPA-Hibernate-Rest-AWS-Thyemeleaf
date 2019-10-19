package com.spring.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.entity.Area;
import com.spring.entity.Pujo;
import com.spring.entity.Res;
import com.spring.service.AreaService;
import com.spring.service.PujoService;
import com.spring.service.ResService;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@RestController
public class UserRestController {
	
	private PujoService pujoService;
	private ResService resService ;
	private AreaService areaService;

	@Autowired   
	public UserRestController(PujoService obj,ResService obj1,AreaService obj3)
	{
		this.pujoService=obj;
		this.resService=obj1;
		this.areaService=obj3;
	}
	
	@GetMapping("/pujo")
	public List<Pujo> AddPujo() {
		
//		List<Pujo> list=pujoService.findAll();
//		Set<String> set=new HashSet<String>();
//		for(Pujo str:list)
//			set.add(str.getDivision());
//		
		
		return pujoService.findAll();
	}
	
	
	
	@PutMapping("/pujo")
	public Pujo updatePujo(@RequestBody Pujo pujo) {
		
		System.out.println("Put Called");
		pujoService.save(pujo);
		
		return pujo;
	}
	
/*
	@PostMapping("/pujo")
	public Pujo upatePujo(@RequestBody Pujo pujo) {
		
		System.out.println("post Called");
		pujoService.save(pujo);
		
		return pujo;
	}*/
	
	@GetMapping("/pujo/{Division}")
	public List<Pujo> DivPujo(@PathVariable String Division) {
		
		
		List<Pujo> list=pujoService.findByDivision(Division);
	/*	Set<String> set=new HashSet<String>();
		for(Pujo str:list)
			set.add(str.getArea());
		

		List<Pujo> l=new ArrayList<>();

		for(String s:set)
		{
			Pujo obj=new Pujo();
			obj.setArea(s);
			obj.setId(0);
			obj.setName("Area");
			obj.setDivision("Area");
			obj.setCount(0);
			obj.setLocation("0");
			obj.setImage("0");
			obj.setOrg("0");
			l.add(obj);
					
		}
		
		return l;*/
		
		return pujoService.findByDivision(Division);
	}
	
/*	@GetMapping("/distinct")
	public List<Pujo> Distinct() {
		

		return pujoRepository.findDistinctById("3");
	}
	*/
	
	
	@GetMapping("/pujo/area/{Area}")
	public List<Pujo> AreaPujo(@PathVariable String Area) {
		

		return pujoService.findByArea(Area);
	}
	
	@GetMapping("/restaurant")
	public List<Res> AllRestaurant() {
		
		return resService.findAll();
	}
	
	
	
	@PutMapping("/restaurant")
	public Res updateRes(@RequestBody Res res) {
		
		resService.save(res);
		
		return res;
	}
	

	@GetMapping("/restaurant/{Division}")
	public List<Res> DivRes(@PathVariable String Division) {
		
		return resService.findByDivision(Division);
	}
	
	

	@GetMapping("/restaurant/area/{area}")
	public List<Res> AreaDiv(@PathVariable String area) {
		
		return resService.findByArea(area);
	}
	
	
	@GetMapping("/area/{Division}")
	public List<Area> DivArea(@PathVariable String Division) {
		
		return areaService.findByDivision(Division);
	}
	
	
	
	
}