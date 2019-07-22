package com.bit.struts.action;

import com.bit.struts.model.IbatisDao;
import com.opensymphony.xwork2.Action;

public class DeleteAction implements Action {
	int idx;
	public void setIdx(int idx) {
		this.idx = idx;
	}

	@Override
	public String execute() throws Exception {
		IbatisDao dao=new IbatisDao();
		if(dao.deleteOne(idx)>0) return this.SUCCESS;
		return this.INPUT;
	}

}
