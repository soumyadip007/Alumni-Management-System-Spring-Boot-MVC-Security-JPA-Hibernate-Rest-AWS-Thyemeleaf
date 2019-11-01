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
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	

	private AMSService amsService;
	@Autowired   
	public AdminController(AMSService obj)
	{
		this.amsService=obj;
	
	}

	@GetMapping("/add-alumni")
	public String Addalumni(Model theModel) {
	
		AMS alumni=new AMS();
		
		theModel.addAttribute("alumni",alumni);
		
		return "dashboard/addAlumni";
	}
	
	@PostMapping("/add-alumni")
	public String Savealumni(@ModelAttribute("alumni") AMS alumni) {

	
		amsService.save(alumni);
	
		return "redirect:/admin/add-alumni";
	}
	
	@GetMapping("/all-alumni")
	public String Allalumni(Model theModel) {

		List<AMS> list=amsService.findAll();
		
		theModel.addAttribute("allalumni",list);
		
		return "dashboard/alumniList";
	}

	
	@GetMapping("/update-alumni")
	public String Updatealumni(@RequestParam("id") int theId,Model theModel) {

		AMS alumni=amsService.findById(theId);
		
		theModel.addAttribute("alumni",alumni);
		
		return "dashboard/addalumni";
	}
	
	@GetMapping("/delete-alumni")
	public String Deletealumni(@RequestParam("id") int theId) {

		amsService.deleteById(theId);
	
		return "redirect:/admin/all-alumni";
	}


	
	@GetMapping("/2019")
	public String year2019(Model theModel) {

		List<AMS> list=amsService.findByYear("2019");
		
		theModel.addAttribute("allalumni",list);
		
		return "dashboard/2019";
	}
	
	@GetMapping("/2020")
	public String year2020(Model theModel) {

		List<AMS> list=amsService.findByYear("2020");
		
		theModel.addAttribute("allalumni",list);
		
		return "dashboard/2020";
	}
	
	
	@GetMapping("/2021")
	public String year2018(Model theModel) {

		List<AMS> list=amsService.findByYear("2021");
		
		theModel.addAttribute("allalumni",list);
		
		return "dashboard/2021";
	}
	
	
	

	@GetMapping("/alumni-count-chart")
	public String Chart(Model theModel) {
	
		List<AMS> list=amsService.findAll();
		 
		theModel.addAttribute("allalumni",list);
		
		int a=0;
		int b=0;
		int c=0;
		
		for(AMS obj:list)
		{
			if(obj.getYear().equals("2019"))
			{
				a+=obj.getClick();
			}
			else if(obj.getYear().equals("2020"))
			{
				b+=obj.getClick();
			}
			else if(obj.getYear().equals("2021"))
			{
				c+=obj.getClick();
			}
			
		}
		theModel.addAttribute("a",a);
		
		theModel.addAttribute("b",b);
		
		theModel.addAttribute("c",c);
		
		System.out.println("a="+a+"b="+b+"c="+c);
		return "dashboard/chart";
	}
}


//
//
//@GetMapping("/alumni-count-chart")
//public String Chart(Model theModel) {
//
//	List<AMS> list=amsService.findAll();
//	 
//	theModel.addAttribute("allalumni",list);
//	
//	int a=0;
//	int b=0;
//	int c=0;
//	
//	for(AMS obj:list)
//	{
//		if(obj.getDivision().equals("North"))
//		{
//			a+=obj.getCount();
//		}
//		else if(obj.getDivision().equals("South"))
//		{
//			b+=obj.getCount();
//		}
//		else if(obj.getDivision().equals("Central"))
//		{
//			c+=obj.getCount();
//		}
//		
//	}
//	theModel.addAttribute("a",a);
//	
//	theModel.addAttribute("b",b);
//	
//	theModel.addAttribute("c",c);
//	
//	System.out.println("a="+a+"b="+b+"c="+c);
//	return "dashboard/chart";
//}














//
//
//@GetMapping("/alumni/2017")
//public String Northalumni(Model theModel) {
//
//	List<AMS> list=amsService.findByDivision("North");
//	
//	theModel.addAttribute("allalumni",list);
//	
//	
//	
//	return "dashboard/northalumniList";
//}
//
//@GetMapping("/alumni/2018")
//public String centralalumni(Model theModel) {
//
//	List<AMS> list=amsService.findByDivision("Central");
//	
//	theModel.addAttribute("allalumni",list);
//	
//	return "dashboard/centralalumniList";
//}
//
//@GetMapping("/south-kolkata")
//public String southalumni(Model theModel) {
//
//	List<AMS> list=amsService.findByDivision("South");
//	
//	theModel.addAttribute("allalumni",list);
//	
//	return "dashboard/southalumniList";
//}

