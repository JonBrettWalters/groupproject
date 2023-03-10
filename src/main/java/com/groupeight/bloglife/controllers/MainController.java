package com.groupeight.bloglife.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;

import com.groupeight.bloglife.services.PostServices;
import com.groupeight.bloglife.services.UserServices;

import com.groupeight.bloglife.models.LoginUser;
import com.groupeight.bloglife.models.Post;
import com.groupeight.bloglife.models.User;

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
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("User") User User, BindingResult result, Model model, HttpSession session) 
    {
        User created_User = userServ.createUser(User, result);

        if(result.hasErrors()) 
        {
            model.addAttribute("LoginUser", new LoginUser());
            return "index.jsp";
        }
        else
        {
            session.setAttribute("user_id", created_User.getId());
            session.setAttribute("firstName", created_User.getFirstName());
        }
        return "redirect:/dashboard";
    }

    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("LoginUser") LoginUser LoginUser, BindingResult result, Model model, HttpSession session) 
    {
        User created_User = userServ.login(LoginUser, result);
        
        if(result.hasErrors()) 
        {
            model.addAttribute("User", new User());
            return "index.jsp";
        }
        else
        {
            session.setAttribute("user_id", created_User.getId() );
            session.setAttribute("firstName", created_User.getFirstName());
        }
        return "redirect:/dashboard";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session, Model model) 
    {
        session.invalidate();
        if(model.containsAttribute("counter")) model.asMap().remove("counter");
        return "redirect:/";
    }
    
    @GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model)
    {
        Long userID = (Long) session.getAttribute("user_id");
        User foundUser = userServ.findUser(userID);
        model.addAttribute("foundUser", foundUser);
        return "dashboard.jsp";
    }

	@GetMapping("/blogs/{id}/view")
	public String view_blog(@PathVariable Long id, Model model)
	{
        Post viewPost = postServ.findPost(id);
        model.addAttribute("viewPost", viewPost);
        return "view_blog.jsp";
	}

	@GetMapping("/blogs/add")
    public String create_blog(HttpSession session, Model model, @ModelAttribute("Post") Post post)
    {
        return "new_blog.jsp";
    }

    @PostMapping("/blogs/submit")
	public String add_blog(@Valid @ModelAttribute("Post") Post Post, BindingResult result, HttpSession session, Model model)
	{
        Long userID = (Long) session.getAttribute("user_id");
        User foundUser = userServ.findUser(userID);
        
        if(result.hasErrors()) 
        {
            return "new_blog.jsp";
        }
        else
        {
            postServ.createPost(Post, foundUser);
            return "redirect:/dashboard";
        }
	}

    @PostMapping("/blogs/{id}/submit")
    //again assuming some validation will be added into the PostServices
    public String submit_update(@Valid @ModelAttribute("editPost") Post Post, BindingResult result, @PathVariable Long id, String description, HttpSession session, Model model)
    {
        if(result.hasErrors())
        {
            return "edit_blog.jsp";
        }
        else   
        {
        	postServ.updatePost(Post);
            return "redirect:/dashboard";
        }
    }

	@GetMapping("/blogs/{id}/edit")
	public String edit_blog(@PathVariable Long id, Model model)
	{
        Post editPost = postServ.findPost(id);
        model.addAttribute("editPost", editPost);
        return "edit_blog.jsp";
    }

    @DeleteMapping("/blogs/{id}/delete")
    public String delete_blog(@PathVariable Long id)
    {
        postServ.deletePost(id);
        return "redirect:/dashboard";
    }


}