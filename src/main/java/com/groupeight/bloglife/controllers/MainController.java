package com.groupeight.bloglife.controllers;

import java.util.*;

import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.ui.*;


import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

import com.groupeight.bloglife.services.PostServices;
import com.groupeight.bloglife.services.UserServices;

import com.models.LoginUser;
import com.authentication.models.User;
import com.authentication.repositories.UserRepository;

@Controller
public class MainController 
{
	@Autowired
	PostServices postServ;
	@Autowired
	UserServices userServ;
	
	//@RequestMapping("/") 
	//public String logandreg() {
	//	return "";
	//}

	@GetMapping("/")
    public String index(Model model) 
    {
        model.addAttribute("User", new User());
        model.addAttribute("LoginUser", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@RequestParam(value="firstname") String firstname, @RequestParam(value="lastname") String lastname, @RequestParam(value="email")String email, @RequestParam(value="password")String password,
	@ModelAttribute("User") User User, BindingResult result, Model model, HttpSession session) 
    {
        String hashed = BCrypt.hashpw(User.getPassword(), BCrypt.gensalt());

        if(result.hasErrors()) 
        {
            model.addAttribute("LoginUser", new LoginUser());
            return "index.jsp";
        }
        else
        {
            HttpSession.setAttribute("User");
        }
        return "redirect:/dashboard";
    }

    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("LoginUser") LoginUser LoginUser, BindingResult result, Model model, HttpSession session) 
    {
        if(result.hasErrors()) 
        {
            model.addAttribute("LoginUser", new LoginUser());
            return "index.jsp";
        }
        else
        {
            HttpSession.setAttribute("User");
        }
        return "redirect:/dashboard";
    }
    
    @PostMapping("/dashboard")
	public String dashboard()
    {
        
    }

	@PostMapping("/blogs/x/view.jsp")
	public String view_blog()
	{

	}

	@PostMapping("/blogs/add.jsp")
	public String add_blog()
	{

	}

	@PostMapping("/blogs/x/edit.jsp")
	public String edit_blog()
	{

	}

}

