package com.sang12.blog.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	@RequestMapping("/pageNotFound")
	public String test(){
		return "error/pageNotFound";
	}
}
