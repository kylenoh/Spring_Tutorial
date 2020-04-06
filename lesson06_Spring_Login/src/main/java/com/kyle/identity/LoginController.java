package com.kyle.identity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/callLogin", method = RequestMethod.GET)
	public String login() {
		return "identity/user/login";
	}
	
}
