package com.bit.struts.action;

import com.bit.struts.model.Struts06Dao;
import com.bit.struts.model.entity.Struts06Vo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class InsertAction implements Action,Preparable,ModelDriven<Struts06Vo>{
	Struts06Vo bean;
	
	public void setBean(Struts06Vo bean) {
		this.bean = bean;
	}

	@Override
	public String execute() throws Exception {
		Struts06Dao dao=new Struts06Dao();
		dao.insertOne(bean);
		return this.SUCCESS;
	}

	@Override
	public Struts06Vo getModel() {
		return this.bean;
	}

	@Override
	public void prepare() throws Exception {
		bean=new Struts06Vo();
	}

}
