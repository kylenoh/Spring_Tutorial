package kr.co.common.repository;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

@SuppressWarnings("deprecation")
public class AbstractDAO extends SqlMapClientDaoSupport{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlMapClient sql;

	
	public void setSuperSqlMapClient(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}
	
	protected void printQueryId(String queryId) {
		if (logger.isDebugEnabled()) {
			logger.debug("\t QueryId \t: " + queryId);
		}
	}

	public Object insert(String queryId, Object params) throws SQLException {
		printQueryId(queryId);
		return getSqlMapClientTemplate().queryForObject(queryId,params);
	}

	public Object update(String queryId, Object params) throws SQLException {
		printQueryId(queryId);
		return sql.update(queryId, params);
	}

	public Object delete(String queryId, Object params) throws SQLException {
		printQueryId(queryId);
		return sql.delete(queryId, params);
	}

	
}
