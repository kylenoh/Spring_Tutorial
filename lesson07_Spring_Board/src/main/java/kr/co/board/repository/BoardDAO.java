package kr.co.board.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.common.repository.AbstractDAO;

@Repository
public class BoardDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		return (List<Map<String, Object>>) selectList("selectBoardList");
	}

	public void insertBoard(Map<String, Object> map) throws Exception {
		insert("insertBoard", map);
	}

	public void updateCnt(Map<String, Object> map) throws Exception{
		update("updateCnt", map);
	}

	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectByIdx("selectBoardDetail", map);
	}
	
	public void updateBoard(Map<String, Object> map) throws Exception {
		update("updateBoard", map);
	}
	
	public void deleteBoard(Map<String, Object> map) throws Exception {
		update("deleteBoard", map);
	}
}
