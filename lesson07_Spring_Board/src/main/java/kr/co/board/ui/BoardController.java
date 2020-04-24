package kr.co.board.ui;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.board.repository.BoardService;

@Controller
public class BoardController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/callBoardList", method = RequestMethod.GET)
	public ModelAndView BoardList(Map<String, Object> commandMap) {
	
		ModelAndView mv = new ModelAndView("/board/boardList");
		List<Map<String, Object>> list = boardService.selectBoardList(commandMap);
		mv.addObject("list", list);
		return mv;

	}
}
