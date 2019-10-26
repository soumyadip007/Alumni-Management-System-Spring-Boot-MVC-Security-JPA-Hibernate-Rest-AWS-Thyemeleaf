package com.spring.mvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entity.AMS;
import com.spring.service.AMSService;
/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	

	private AMSService amsService;
	@Autowired   
	public UserController(AMSService obj)
	{
		this.amsService=obj;
	
	}

	
	
	@GetMapping("/alumni")
	public String Allalumni(Model theModel) {

		AMS list=(AMS) amsService.findByEnrl("12017009001027");
		
		theModel.addAttribute("list",list);
	//	theModel.addAttribute("allalumni",list);
		
		System.out.println(list);
		return "user/alumni-details";
	}



	@GetMapping("/index")
	public String all(Model theModel) {

		List<AMS> list=amsService.findAll();
		
		theModel.addAttribute("allalumni",list);
		
		return "user/index";
	}
	
	
	

//	@GetMapping("/id")
//	public String getById(@RequestParam("id") int theId,Model theModel) {
//
//		String enrl= String.valueOf(theId);
//		List<AMS> list=amsService.findById(enrl);
//		
//		theModel.addAttribute("allalumni",list);
//		
//		return "dashboard/2021";
//	}
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

