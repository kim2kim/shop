package com.shop.web;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "Hello World");
		model.put("title", "Hello Home");
		model.put("date", new Date());
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}

	@RequestMapping("/home")
	public String home(){
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
    @RequestMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }
}
