package com.bit.action;

import com.opensymphony.xwork2.Action;

public class ResultAction implements Action {
	String id,pw;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String execute() throws Exception {
		if(id.equals("")||pw.equals(""))return this.INPUT;
		return this.SUCCESS;
	}

}















