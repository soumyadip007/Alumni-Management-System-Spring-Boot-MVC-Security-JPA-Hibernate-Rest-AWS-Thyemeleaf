package com.spring.mvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@Controller
@RequestMapping("/admin")
public class AdminController {
	

	private PujoService pujoService;
	private ResService resService ;
	private AreaService areaService ;

	@Autowired   
	public AdminController(PujoService obj,ResService obj1,AreaService obj2)
	{
		this.pujoService=obj;
		this.resService=obj1;
		this.areaService=obj2;
	}

	@GetMapping("/add-pujo")
	public String AddPujo(Model theModel) {
	
		Pujo pujo=new Pujo();
		
		theModel.addAttribute("pujo",pujo);
		
		return "dashboard/addPujo";
	}
	
	@PostMapping("/add-pujo")
	public String SavePujo(@ModelAttribute("pujo") Pujo pujo) {

	//	pujo.setId(2);
		pujoService.save(pujo);
	
		System.out.println(pujo.getArea());
		
		List<Area> list=areaService.findBySub(pujo.getArea());
		System.out.println("List size"+list.size());
		
		if(list.size()<1)
		{
			System.out.println("List size"+list.size());
			Area area=new Area();
			area.setSub(pujo.getArea());
			area.setDivision(pujo.getDivision());
			area.setImage(pujo.getImage());		

			System.out.println(area);
			areaService.save(area);

		}
	
		
		return "redirect:/admin/add-pujo";
	}
	
	@GetMapping("/all-pujo")
	public String AllPujo(Model theModel) {

		List<Pujo> list=pujoService.findAll();
		
		theModel.addAttribute("allpujo",list);
		
		return "dashboard/pujoList";
	}
	
	@GetMapping("/pujo-count-chart")
	public String Chart(Model theModel) {

		List<Pujo> list=pujoService.findAll();
		 
		theModel.addAttribute("allpujo",list);
		
		int a=0;
		int b=0;
		int c=0;
		
		for(Pujo obj:list)
		{
			if(obj.getDivision().equals("North"))
			{
				a+=obj.getCount();
			}
			else if(obj.getDivision().equals("South"))
			{
				b+=obj.getCount();
			}
			else if(obj.getDivision().equals("Central"))
			{
				c+=obj.getCount();
			}
			
		}
		theModel.addAttribute("a",a);
		
		theModel.addAttribute("b",b);
		
		theModel.addAttribute("c",c);
		
		System.out.println("a="+a+"b="+b+"c="+c);
		return "dashboard/chart";
	}
	
	
	@GetMapping("/north-kolkata")
	public String NorthPujo(Model theModel) {

		List<Pujo> list=pujoService.findByDivision("North");
		
		theModel.addAttribute("allpujo",list);
		
		
		
		return "dashboard/northPujoList";
	}
	
	@GetMapping("/central-kolkata")
	public String centralPujo(Model theModel) {

		List<Pujo> list=pujoService.findByDivision("Central");
		
		theModel.addAttribute("allpujo",list);
		
		return "dashboard/centralPujoList";
	}
	
	@GetMapping("/south-kolkata")
	public String southPujo(Model theModel) {

		List<Pujo> list=pujoService.findByDivision("South");
		
		theModel.addAttribute("allpujo",list);
		
		return "dashboard/southPujoList";
	}
	
	
	@GetMapping("/update-pujo")
	public String UpdatePujo(@RequestParam("id") int theId,Model theModel) {

		Pujo pujo=pujoService.findById(theId);
		
		theModel.addAttribute("pujo",pujo);
		
		return "dashboard/addPujo";
	}
	
	@GetMapping("/delete-pujo")
	public String DeletePujo(@RequestParam("id") int theId) {

		pujoService.deleteById(theId);
	
		return "redirect:/admin/all-pujo";
	}
	
	@GetMapping("/add-restaurant")
	public String AddRes(Model theModel) {

		Res pujo=new Res();
		
		theModel.addAttribute("res",pujo);
		
		
		return "dashboard/addRestaurant";
	}

	
	@PostMapping("/add-restaurant")
	public String Saveres(@ModelAttribute("res") Res res) {

	//	res.setId(2);
		resService.save(res);
		return "redirect:/admin/add-restaurant";
	}
	
	@GetMapping("/all-restaurant")
	public String Allres(Model theModel) {

		List<Res> list=resService.findAll();
		
		theModel.addAttribute("allres",list);
		
		return "dashboard/resList";
	}
	
	@GetMapping("/north-kolkata-restaurant")
	public String Northres(Model theModel) {

		List<Res> list=resService.findByDivision("North");
		
		theModel.addAttribute("allres",list);
		
		return "dashboard/northResList";
	}
	
	@GetMapping("/central-kolkata-restaurant")
	public String centralres(Model theModel) {

		List<Res> list=resService.findByDivision("Central");
		
		theModel.addAttribute("allres",list);
		
		return "dashboard/centralResList";
	}
	
	@GetMapping("/south-kolkata-restaurant")
	public String southres(Model theModel) {

		List<Res> list=resService.findByDivision("South");
		
		theModel.addAttribute("allres",list);
		
		return "dashboard/southResList";
	}
	
	
	@GetMapping("/update-restaurant")
	public String Updateres(@RequestParam("id") int theId,Model theModel) {

		Res res=resService.findById(theId);
		
		theModel.addAttribute("res",res);
		
		return "dashboard/addRestaurant";
	}
	
	@GetMapping("/delete-restaurant")
	public String Deleteres(@RequestParam("id") int theId) {

		resService.deleteById(theId);
	
		return "redirect:/admin/all-restaurant";
	}
	
	@GetMapping("/restaurant-count-chart")
	public String ResChart(Model theModel) {

		List<Res> list=resService.findAll();
		 
		theModel.addAttribute("allpujo",list);
		
		int a=0;
		int b=0;
		int c=0;
		
		for(Res obj:list)
		{
			if(obj.getDivision().equals("North"))
			{
				a+=obj.getCount();
			}
			else if(obj.getDivision().equals("South"))
			{
				b+=obj.getCount();
			}
			else if(obj.getDivision().equals("Central"))
			{
				c+=obj.getCount();
			}
			
		}
		theModel.addAttribute("a",a);
		
		theModel.addAttribute("b",b);
		
		theModel.addAttribute("c",c);
		
		System.out.println("a="+a+"b="+b+"c="+c);
		return "dashboard/chartRes";
	}
	
	
	
	@GetMapping("/add-area")
	public String AddArea(Model theModel) {

		Area area=new Area();
		
		theModel.addAttribute("area",area);
		
		
		return "dashboard/addArea";
	}

	
	@PostMapping("/add-area")
	public String AddArea(@ModelAttribute("area") Area area) {

		if(area.getId()!=0)
		{
			areaService.save(area);
		}
		else {
			
		List<Area> list=areaService.findBySub(area.getSub());
		System.out.println("List size"+list.size());
		
		if(list.size()<1)
		{
			areaService.save(area);
		}
			}
		return "redirect:/admin/add-area";
	}
	
	@GetMapping("/all-area")
	public String AllArea(Model theModel) {

		List<Area> list=areaService.findAll();
		
		theModel.addAttribute("allarea",list);
		
		return "dashboard/areaList";
	}
	
	
	@GetMapping("/update-area")
	public String UpdateArea(@RequestParam("id") int theId,Model theModel) {

		Area area=areaService.findById(theId);
		
		theModel.addAttribute("area",area);
		
		return "dashboard/addArea";
	}
	
	@GetMapping("/delete-area")
	public String DeleteArea(@RequestParam("id") int theId) {

		areaService.deleteById(theId);
	
		return "redirect:/admin/all-area";
	}
	
	
	
}
