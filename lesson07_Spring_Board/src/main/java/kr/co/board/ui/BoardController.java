package kr.co.board.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.board.repository.BoardService;
import kr.co.common.commonCode.CustomMap;

@Controller
public class BoardController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/callBoardList", method = RequestMethod.GET)
	public ModelAndView BoardList(Map<String, Object> CustomMap) {

		ModelAndView mv = new ModelAndView("/board/boardList");
		List<Map<String, Object>> list = boardService.selectBoardList(CustomMap);
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping(value = "/callMapArgumentResolver")
	public ModelAndView testMapArgumentResolver(CustomMap customMap) throws Exception {
		ModelAndView mv = new ModelAndView("");
		if (customMap.isEmpty() == false) {
			Iterator<Entry<String, Object>> iterator = customMap.getMap().entrySet().iterator();
			Entry<String, Object> entry = null;
			while (iterator.hasNext()) {
				entry = iterator.next();
				log.debug("key : " + entry.getKey() + ", value : " + entry.getValue());
			}
		}
		return mv;
	}

}
