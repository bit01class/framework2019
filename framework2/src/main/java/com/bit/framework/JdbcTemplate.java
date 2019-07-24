package com.bit.framework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class JdbcTemplate<T> {
	DataSource dataSource;
	
	public JdbcTemplate(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

	public int executeUpdate(String sql,Object[] objs) throws SQLException{
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1, objs[i]);
			}
			return pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}

	public List<T> queryForList(String sql,RowMapper<T> row,Object[] objs) throws SQLException{
		List<T> list=new ArrayList<T>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1, objs[i]);
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(row.mapper(rs));
			}
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return list;
	}
	
	
}

























