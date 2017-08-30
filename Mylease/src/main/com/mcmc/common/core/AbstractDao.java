package com.mcmc.common.core;

import java.sql.SQLException;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dywz.common.utils.ConnectionPool;
import com.mchange.v2.c3p0.impl.NewPooledConnection;

/**
 * 
 * @author UncleDrew
 * @Title AbstractDao.java
 * @Description Dao层必继承
 * @time 2017年5月16日 下午9:47:58
 */
public class AbstractDao {

	protected static QueryRunner qr = new QueryRunner(ConnectionPool.getDataSource());
	
	
	
	
	public synchronized String insert(String sql, Object param) throws SQLException{
		
		String randomUUID = primaryKey(sql);
		
		sql = updateSql(sql);
		/* 构造参数 */
		Object[] paramsAddId = new Object[2];
		
		paramsAddId[0] = randomUUID;
		paramsAddId[1] = param;
		try {
			qr.update(sql, paramsAddId);
		} catch (SQLException e) {
			System.out.println("插入失败");
		}
		return randomUUID;
	}
	
	
	
	
	public  String insert(String sql, Object[] params) throws SQLException {
		String randomUUID = primaryKey(sql);
		sql = updateSql(sql);
		/*构造参数*/
		Object[] paramsAddId = new Object[params.length+1];
		
		paramsAddId[0] = randomUUID;
		for (int i = 0; i < params.length; i++) {
			paramsAddId[i+1]=params[i];
		}
		try {
			qr.update(sql, paramsAddId);
		} catch (SQLException e) {
			System.out.println("插入失败");
		}
		return randomUUID;
	}
	
	
	
	
	
	
	
	
	
	
	private  String primaryKey(String sql) throws SQLException {
		sql=sql.toLowerCase();
		String randomUUID = null;
		if (sql!=null&&sql.contains("insert")&&sql.contains("into")) {
			String tmp=null;
			tmp=sql.replace("insert", "");
			tmp=tmp.replace("into", "").trim();
			String trimSql = tmp;
			
			int leftBracket = tmp.indexOf('(');
			String table=trimSql.substring(0,leftBracket).trim();
			
			while (true) {
				randomUUID=UUID.randomUUID().toString();
				String queryByIdSql="SELECT id FROM "+table+ " WHERE id=?";
				String id = qr.query(queryByIdSql, new ScalarHandler<String>(), randomUUID);
				if (id!=null)
					continue;
				else 
					break;
			}
		}
		return randomUUID;	
	}
	
	
	
	private String updateSql(String sql) {

		if (leftBracketCount(sql) == 2) {
			/*		INSERT INTO table(a,b) VALUES(?,?)*/
			int leftBracket1 = sql.indexOf('(');

			String left = sql.substring(0, leftBracket1 + 1);
			String right = sql.substring(leftBracket1 + 1).trim();

			left = left + "id ,  " ;
			
			int rightLeftBracket = right.indexOf('(');
			
			String rightLeft = right.substring(0,rightLeftBracket+1);
			String rightRight = right.substring(rightLeftBracket+1);
			right = rightLeft + "?, " + rightRight;
			return left+right;
		}else{
			/*INSERT INTO table VALUES(?,?)*/
			int leftBracket1 = sql.indexOf('(');

			String left = sql.substring(0, leftBracket1 + 1);
			String right = sql.substring(leftBracket1 + 1).trim();

			return left+ "?, " + right;
		}
		
	}
	
	
	
	
	
	private int leftBracketCount(String sql){
		char[] charArray = sql.toCharArray();
		int count =0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '(')
				count++;
			if (count > 1) 
				break;
		}
		return count;
		
	}
	
	
	
	
	public int update(String sql, Object[] params) throws SQLException {
		Integer updateColumn=null;
		try {
			updateColumn = qr.update(sql, params);
		} catch (SQLException e) {
			System.out.println("更新失败");
		}
		return updateColumn;
	}
	
	
	
	public  int update(String sql, Object param) throws SQLException {
		Integer updateColumn=null;
		try {
			updateColumn = qr.update(sql, param);
		} catch (SQLException e) {
			System.out.println("更新失败");
		}
		return updateColumn;
	}
	
	
	public <T> T query(String sql,ResultSetHandler<T> rsh, Object[] params) throws SQLException {
		T t=null;
		try {
			t=qr.query(sql, rsh, params);
		} catch (SQLException e) {
			System.out.println("查询失败");		
		}
		return t;
	}
	
	
	
	public <T> T query(String sql,ResultSetHandler<T> rsh, Object param) throws SQLException {
		T t=null;
		try {
			t=qr.query(sql, rsh, param);
		} catch (SQLException e) {
			System.out.println("查询失败");		
		}
		return t;
	}
	
	
	
	public <T> T query(String sql,ResultSetHandler<T> rsh) throws SQLException {
		T t=null;
		try {
			t=qr.query(sql, rsh);
		} catch (SQLException e) {
			System.out.println("查询失败");		
		}
		return t;
	}

	
	
}
