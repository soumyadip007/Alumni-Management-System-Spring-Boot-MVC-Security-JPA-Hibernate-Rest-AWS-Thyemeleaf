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
		
		return "dashboard/addalumni";
	}
	
	@PostMapping("/add-alumni")
	public String Savealumni(@ModelAttribute("alumni") AMS alumni) {

	//	alumni.setId(2);
		amsService.save(alumni);
	
	//	System.out.println(alumni.getArea());
	
		
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

