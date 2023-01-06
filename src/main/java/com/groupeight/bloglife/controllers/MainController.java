package com.groupeight.bloglife.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

import com.groupeight.bloglife.services.PostServices;
import com.groupeight.bloglife.services.UserServices;

import com.groupeight.bloglife.models.LoginUser;
import com.groupeight.bloglife.models.Post;
import com.groupeight.bloglife.models.User;
import com.groupeight.bloglife.repositories.UserRepository;

@Controller
public class MainController 
{
	@Autowired
	PostServices postServ;
	@Autowired
	UserServices userServ;
	
	@GetMapping("/")
    public String index(Model model) 
    {
        model.addAttribute("User", new User());
        model.addAttribute("LoginUser", new LoginUser());
        return "index";
    }
    
    @PostMapping("/register")
    public String register(@RequestParam(value="firstname") String firstname, @RequestParam(value="lastname") String lastname, @RequestParam(value="email")String email, @RequestParam(value="password")String password,
	@ModelAttribute("User") User User, BindingResult result, Model model, HttpSession session) 
    {
        User created_User = userServ.createUser(User, result);

        if(result.hasErrors()) 
        {
            model.addAttribute("LoginUser", new LoginUser());
            return "index";
        }
        else
        {
            session.setAttribute("user_id", created_User.getId());
        }
        return "redirect:/home";
    }

    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("LoginUser") LoginUser LoginUser, BindingResult result, Model model, HttpSession session) 
    {
        User created_User = userServ.login(LoginUser, result);
        
        if(result.hasErrors()) 
        {
            model.addAttribute("LoginUser", new LoginUser());
            return "index";
        }
        else
        {
            session.setAttribute("user_id", created_User.getId() );
        }
        return "redirect:/home";
    }
    
    @GetMapping("/dashboard")
	public String dashboard()
    {
    //think we need another service which returns all post for that given user? 
    //for now, calling 'all posts'
        List<Post> dashboard = postServ.allPosts();
        return "home";
    }

	@PostMapping("/blogs/{id}/view")
	public String view_blog(@PathVariable Long id)
	{
        Post viewPost = postServ.findPost(id);
    //need to check and see if "view" is correct?
        return "view_blog";
	}

	@PostMapping("/blogs/add")
    //assuming that some validation will be added into the PostServices, leaving this in there. 
	public String add_blog(@Valid, @ModelAttribute("Post") Post Post, @RequestParam(value="title") String title, @RequestParam(value="subtitle") String subtitle, @RequestParam(value="plannedDate") Date plannedDate, @RequestParam(value="description") String description,
    HttpSession session)
	{
        Post created_Post = postServ.createPost(Post);
        return "home";
	}
    
    @PostMapping("/blogs/{id}/submit")
    //again assuming some validation will be added into the PostServices
    public String submit_update(@Valid, @PathVariable Long id, @ModelAttribute("Post") Post Post, @RequestParam(value="title") String title, @RequestParam(value="subtitle") String subtitle, 
    @RequestParam(value="plannedDate") Date plannedDate, @RequestParam(value="description") String description, HttpSession session)
    {
        Post edited_Post = postServ.updatePost(Post);
        return "home";
    }

	@PostMapping("/blogs/{id}/edit")
	public String edit_blog(@PathVariable Long id)
	{
        Post editPost = postServ.findPost(id);
        //need to check and see if "view" is correct?
        return "edit_blog";
    }


}
