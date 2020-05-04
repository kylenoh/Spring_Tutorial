package kr.co.common.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

@SuppressWarnings("deprecation")
public class AbstractDAO  {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired private SqlMapClientTemplate sqlSession;

	
	protected void printQueryId(String queryId) {
		if (logger.isDebugEnabled()) {
			logger.debug("\t QueryId \t: " + queryId);
		}
	}

	@SuppressWarnings("rawtypes")
	public List selectList(String queryId){
		printQueryId(queryId);
		return sqlSession.queryForList(queryId);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List selectList(String queryId, Object params) {
		printQueryId(queryId);
		return (ArrayList<String>) sqlSession.queryForList(queryId, params);
	}
	
	@SuppressWarnings({ "unchecked" })
	public Map<String, Object> selectByIdx(String queryId){
		printQueryId(queryId);
		return (Map<String, Object>) sqlSession.queryForObject(queryId);
	}
	
	@SuppressWarnings({ "unchecked" })
	public Map<String, Object> selectByIdx(String queryId, Object params){
		printQueryId(queryId);
		return (Map<String, Object>) sqlSession.queryForObject(queryId, params);
	}
	
	public Object insert(String queryId, Object params) throws SQLException {
		printQueryId(queryId);
		return sqlSession.insert(queryId, params);
	}

	public Object update(String queryId, Object params) throws SQLException {
		printQueryId(queryId);
		return sqlSession.update(queryId, params);
	}

	public Object delete(String queryId, Object params) throws SQLException {
		printQueryId(queryId);
		return sqlSession.delete(queryId, params);
	}

}
