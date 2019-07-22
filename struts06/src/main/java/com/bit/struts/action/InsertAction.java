package com.bit.struts.action;

import org.apache.log4j.Logger;

import com.bit.struts.model.IbatisDao;
import com.bit.struts.model.Struts06Dao;
import com.bit.struts.model.entity.Struts06Vo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class InsertAction extends ActionSupport implements Preparable,ModelDriven<Struts06Vo>{
	Logger log = Logger.getLogger("com.bit.struts.action.InsertAction");
	Struts06Vo bean;
	
	public void setBean(Struts06Vo bean) {
		this.bean = bean;
	}
	
	@Override
	public void validate() {
		log.debug(bean);
		if(bean.getSub().equals("")|| bean.getSub()==null){
			addFieldError("sub","제목없음");
		}
		if(bean.getName().equals("")||bean.getName()==null){
			addFieldError("name", "글쓴이없음");
		}
	}
	

	@Override
	public String execute() throws Exception {
		if(hasErrors())return this.INPUT;
		IbatisDao dao=new IbatisDao();
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
