package com.bit.struts.model;

import java.util.ArrayList;
import java.util.List;

import com.bit.struts.model.entity.Struts06Vo;

public class Struts06Dao {

	public List<Struts06Vo> getList() {
		List<Struts06Vo> list=new ArrayList<Struts06Vo>();
		String sql="SELECT NUM,NAME,SUB,NALJA FROM STRUTS06 ORDER BY NUM";
		
		
		
		
		
		
		
		return list;
	}

}
