package kr.co.board.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.board.serviceImpl.BoardServiceImpl;

@Service
public class BoardService implements BoardServiceImpl {

	@Autowired
	private BoardDAO boardDAO;


	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map){
		return boardDAO.selectBoardList(map);
	}

	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
		boardDAO.insertBoard(map);
	}

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		return null;
	}

	@Override
	public void updateBoard(Map<String, Object> map) throws Exception {
	}

	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
	}

}
