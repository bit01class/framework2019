package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bit.framework.JdbcTemplate;
import com.bit.model.entity.Bbs02Vo;

public class Bbs02Dao2 {

	public List getList() throws SQLException{
		String sql="SELECT * FROM BBS02 ORDER BY NUM DESC";
		JdbcTemplate template = new JdbcTemplate() {
			
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				Bbs02Vo bean=new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
//				bean.setContent(rs.getString("content"));
				bean.setNalja(rs.getDate("nalja"));
				return bean;
			}
		};
		return template.executeQuery(sql);
	}
	
	public Bbs02Vo getOne(int num) throws SQLException{
		String sql="select * from bbs02 where num=?";
		JdbcTemplate template = new JdbcTemplate() {
			
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				Bbs02Vo bean=new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setContent(rs.getString("content"));
				bean.setNalja(rs.getDate("nalja"));
				return bean;
			}
		};
		return (Bbs02Vo) template.queryForObject(sql, new Object[]{num});
	}
	
	public void addOne(Bbs02Vo bean) throws SQLException{
		String sql="insert into bbs02 values (bbs02_seq.nextval,?,?,?,sysdate)";
		JdbcTemplate template = new JdbcTemplate() {
			
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		template.executeUpdate(sql, new Object[]{bean.getName()
				,bean.getSub(),bean.getContent()});
	}
	
	public int delOne(int num) throws SQLException{
		String sql="delete from bbs02 where num=?";
		JdbcTemplate template=new JdbcTemplate() {
			
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return template.executeUpdate(sql, new Object[]{num});
	}
}

















