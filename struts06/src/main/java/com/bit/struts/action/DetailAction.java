package com.bit.struts.action;

import com.bit.struts.model.IbatisDao;
import com.bit.struts.model.Struts06Dao;
import com.bit.struts.model.entity.Struts06Vo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class DetailAction implements Action,ModelDriven<Struts06Vo> {
	private Struts06Vo bean=new Struts06Vo();
	
	public Struts06Vo getBean() {
		return bean;
	}
	
	public void setBean(Struts06Vo bean) {
		this.bean = bean;
	}

	@Override
	public String execute() throws Exception {
		IbatisDao dao=new IbatisDao();
		bean=dao.listOne(bean.getNum());
		return this.SUCCESS;
	}

	@Override
	public Struts06Vo getModel() {
		return bean;
	}

}



















