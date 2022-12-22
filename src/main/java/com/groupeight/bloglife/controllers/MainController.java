package com.groupeight.bloglife.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupeight.bloglife.services.PostServices;
import com.groupeight.bloglife.services.UserServices;

@Controller
public class MainController {
	@Autowired
	PostServices postServ;
	@Autowired
	UserServices userServ;
	
	@RequestMapping("/") 
	public String logandreg() {
		return "";
	}
	
	
}
