package com.bit.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="scott";
	private String password="tiger";
	Connection conn=null;
	
	public JdbcTemplate() {
	}
	
	public JdbcTemplate(javax.sql.DataSource dataSource) {
		try {
			conn=dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public JdbcTemplate(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
		driver=dataSource.getDriverClassName();
		url=dataSource.getUrl();
		user=dataSource.getUsername();
		password=dataSource.getPassword();
	}
	
	public Connection getConnection(){
		try {
			if(conn==null || conn.isClosed()){
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public int executeUpdate(String sql,Object[] objs) throws SQLException{
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1,objs[i]);
			}
			return pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
	public Object queryForObject(String sql,Object[] objs) throws SQLException{
		return executeQuery(sql,objs).get(0);
	}
	public List executeQuery(String sql) throws SQLException{
		return executeQuery(sql, new Object[]{});
	}
	public List executeQuery(String sql,Object[] objs) throws SQLException{
		List list= new ArrayList();
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1, objs[i]);
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(mapper(rs));
			}
		} finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return list;
	}
	
	public abstract Object mapper(ResultSet rs) throws SQLException;
}
