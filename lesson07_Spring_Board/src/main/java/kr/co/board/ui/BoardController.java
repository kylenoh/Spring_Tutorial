package kr.co.board.ui;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	Logger log = LoggerFactory.getLogger(this.getClass());


	@RequestMapping(value = "/callBoardList", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("인터셉터 테스트!");
		
		return "board/boardList";
	}
}
