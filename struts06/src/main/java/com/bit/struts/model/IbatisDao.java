package com.bit.struts.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.bit.struts.model.entity.Struts06Vo;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisDao {
	SqlMapClient sqlMapClient;
	
	public IbatisDao() {
		try {
			Reader reader = Resources.getResourceAsReader("/SqlMapConfig.xml");
			sqlMapClient=SqlMapClientBuilder.buildSqlMapClient(reader);
			
//			InputStream is=new FileInputStream("C:\\java\\workspace3\\struts06\\src\\main\\resources\\SqlMapConfig.xml");
//			sqlMapClient=SqlMapClientBuilder.buildSqlMapClient(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Struts06Vo> getList() throws SQLException {
		return sqlMapClient.queryForList("selectAll");
	}
}















