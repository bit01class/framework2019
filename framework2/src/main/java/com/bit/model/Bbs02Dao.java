package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import com.bit.framework.JdbcTemplate;
import com.bit.framework.RowMapper;
import com.bit.model.entity.Bbs02Vo;

public class Bbs02Dao {
	DataSource dataSource;

	public Bbs02Dao() throws SQLException {
			OracleDataSource oracle = null;
			oracle=new OracleDataSource();
			oracle.setDriverType("oracle.jdbc.OracleDriver");
			oracle.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			oracle.setUser("scott");
			oracle.setPassword("tiger");
			dataSource=oracle;
	}
	
	public int insertOne(Bbs02Vo bean) throws SQLException{
		String sql="insert into bbs02 values (bbs02_seq.nextval,?,?,?,sysdate)";
		Object[] params={bean.getName(),bean.getSub(),bean.getContent()};
		JdbcTemplate template=new JdbcTemplate(dataSource);
		
		return template.executeUpdate(sql, params);
	}
	
	
	public List<Bbs02Vo> selectAll(String keyword) throws SQLException{
		String sql="select * from bbs02 where sub like '%'||?||'%' order by num desc";
		Object[] args={keyword};
		JdbcTemplate<Bbs02Vo> template=new JdbcTemplate<Bbs02Vo>(dataSource);
		
		return template.queryForList(sql,new RowMapper<Bbs02Vo>(){

			@Override
			public Bbs02Vo mapper(ResultSet rs) throws SQLException {
				Bbs02Vo bean=new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setContent(rs.getString("content"));
				bean.setNalja(rs.getDate("nalja"));
				return bean;
			}
			
		}, args);
	}
	
}























