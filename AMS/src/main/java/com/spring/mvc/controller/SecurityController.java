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
public class SecurityController {


	@RequestMapping("/adminlogin")
	public String showHome()
	{
		
		return "security/login";
	}

}
