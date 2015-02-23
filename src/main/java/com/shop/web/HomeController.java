package com.shop.web;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.model.User;
import com.shop.service.UserRepository;

@Controller
public class HomeController {
	
	@Resource
	private UserRepository userRepository;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		Iterable<User> col = userRepository.findAll();
		
		long count = userRepository.count();
		System.out.println("count " + count);
		request.setAttribute("userCount", count);
		//model.addAttribute("userCount", count);
		return "login";
	}

	@RequestMapping("/home")
	public String home(Map<String, Object> model){
		model.put("message", "Hello World");
		model.put("title", "Hello Home");
		model.put("date", new Date());
		return "home";
	}
	

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
    
    /**
     * Handles '/signup'
     * @param model
     * @return
     */
    @RequestMapping(value = "/signup", method=RequestMethod.POST)
    public String signup(@ModelAttribute User user, Model model) {
    	model.addAttribute("user", user);
        return "signup";
    }
}
