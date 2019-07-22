package com.bit.struts.action;

import java.util.List;

import com.bit.struts.model.IbatisDao;
import com.bit.struts.model.Struts06Dao;
import com.bit.struts.model.entity.Struts06Vo;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {
	List<Struts06Vo> alist;
	
	public List<Struts06Vo> getAlist() {
		return alist;
	}

	@Override
	public String execute() throws Exception {
		IbatisDao dao=new IbatisDao();
		alist=dao.getList();
		return this.SUCCESS;
	}

}

















