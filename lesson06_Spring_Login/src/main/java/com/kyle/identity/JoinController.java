package com.kyle.identity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinController {
	
	@RequestMapping(value = "/callJoin", method = RequestMethod.GET)
	public String Join() {
		return "identity/anonymous/join";
	}

	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public String Insert() {
		
		return "identity/anonymous/join";
	}
}
