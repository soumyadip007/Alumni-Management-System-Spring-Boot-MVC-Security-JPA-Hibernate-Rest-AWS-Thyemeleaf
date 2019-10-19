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

import com.spring.entity.AMS;
import com.spring.service.AMSService;
/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	

	private AMSService pujoService;
	@Autowired   
	public AdminController(AMSService obj)
	{
		this.pujoService=obj;
	
	}

	@GetMapping("/add-pujo")
	public String AddPujo(Model theModel) {
	
		AMS pujo=new AMS();
		
		theModel.addAttribute("pujo",pujo);
		
		return "dashboard/addPujo";
	}
	
	@PostMapping("/add-pujo")
	public String SavePujo(@ModelAttribute("pujo") AMS pujo) {

	//	pujo.setId(2);
		pujoService.save(pujo);
	
		System.out.println(pujo.getArea());
	
		
		return "redirect:/admin/add-pujo";
	}
	
	@GetMapping("/all-pujo")
	public String AllPujo(Model theModel) {

		List<AMS> list=pujoService.findAll();
		
		theModel.addAttribute("allpujo",list);
		
		return "dashboard/pujoList";
	}
	
	@GetMapping("/pujo-count-chart")
	public String Chart(Model theModel) {

		List<AMS> list=pujoService.findAll();
		 
		theModel.addAttribute("allpujo",list);
		
		int a=0;
		int b=0;
		int c=0;
		
		for(AMS obj:list)
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

		List<AMS> list=pujoService.findByDivision("North");
		
		theModel.addAttribute("allpujo",list);
		
		
		
		return "dashboard/northPujoList";
	}
	
	@GetMapping("/central-kolkata")
	public String centralPujo(Model theModel) {

		List<AMS> list=pujoService.findByDivision("Central");
		
		theModel.addAttribute("allpujo",list);
		
		return "dashboard/centralPujoList";
	}
	
	@GetMapping("/south-kolkata")
	public String southPujo(Model theModel) {

		List<AMS> list=pujoService.findByDivision("South");
		
		theModel.addAttribute("allpujo",list);
		
		return "dashboard/southPujoList";
	}
	
	
	@GetMapping("/update-pujo")
	public String UpdatePujo(@RequestParam("id") int theId,Model theModel) {

		AMS pujo=pujoService.findById(theId);
		
		theModel.addAttribute("pujo",pujo);
		
		return "dashboard/addPujo";
	}
	
	@GetMapping("/delete-pujo")
	public String DeletePujo(@RequestParam("id") int theId) {

		pujoService.deleteById(theId);
	
		return "redirect:/admin/all-pujo";
	}
	

	
}