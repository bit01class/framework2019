package com.bit.model.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bbs02Dao1 {
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="scott";
	private String password="tiger";

	public Bbs02Dao1() {
		
	}
	
	public Connection getConnection(){
		Connection conn=null;
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
	
	public List getList() throws SQLException{
		String sql="select num,name,sub,nalja from bbs02";
		List list= new ArrayList();
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Bbs02Vo bean=new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setNalja(rs.getDate("nalja"));
				list.add(bean);
			}
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}

	public Bbs02Vo selectOne(int num) throws SQLException {
		String sql="select * from bbs02 where num=?";
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				Bbs02Vo bean=new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setContent(rs.getString("content"));
				bean.setNalja(rs.getDate("nalja"));
				return bean;
			}
		}finally{
			closeAll(conn, pstmt, rs);
		}
		return null;
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
			closeAll(conn, pstmt, null);
		}
	}

	public void insertOne(String name, String sub, String content) throws SQLException {
		String sql="insert into bbs02 values (bbs02_seq.nextval,?,?,?,sysdate)";
		executeUpdate(sql, new Object[]{name,sub,content});
	}
	
	public int updateOne(Bbs02Vo bean) throws SQLException{
		String sql="update bbs02 set sub=?,content=? where num=?";
		return executeUpdate(sql
		,new Object[]{bean.getSub(),bean.getContent(),bean.getNum()});
	}
	
	public int deleteOne(int num) throws SQLException{
		String sql="delete from bbs02 where num=?";
		return executeUpdate(sql, new Object[]{num});
	}
	
	
	public void closeAll(Connection conn,PreparedStatement pstmt
			,ResultSet rs) throws SQLException{
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
}


















