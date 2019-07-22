package com.bit.struts.action;

import com.bit.struts.model.IbatisDao;
import com.bit.struts.model.entity.Struts06Vo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateAction extends ActionSupport implements ModelDriven<Struts06Vo> {
	private Struts06Vo bean=new Struts06Vo();
	
	public void setBean(Struts06Vo bean) {
		this.bean = bean;
	}
	public Struts06Vo getBean() {
		return bean;
	}
	
	@Override
	public void validate() {
		if(bean.getSub().isEmpty()){
			addFieldError("sub", "제목없음");
		}
		if(bean.getName().isEmpty()){
			addFieldError("name","글쓴이없음");
		}
	}

	@Override
	public String execute() throws Exception {
		IbatisDao dao=new IbatisDao();
		if(dao.updateOne(bean)>0)return this.SUCCESS;
		return this.INPUT;
	}

	@Override
	public Struts06Vo getModel() {
		return bean;
	}
}










