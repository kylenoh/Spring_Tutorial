package kr.co.sample.portal.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PortalMainController {
	
	private static final Logger logger = LoggerFactory.getLogger(PortalMainController.class);
	
	@RequestMapping(value = "/portal/main", method = RequestMethod.GET)
	public ModelAndView main(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);
		
		ModelMap map = new ModelMap();
		map.addAttribute("minHour", today + " 00:00");
		map.addAttribute("maxHour", today + " 23:59");
		
		return new ModelAndView("/portal/main", map);
	}
	
}
