package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;

public class IndexController implements Controller{
	
	public IndexController() {
		System.out.println("new IndexController");
	}

	public String execute(HttpServletRequest req)  throws SQLException{
		req.setAttribute("msg", "ȯ���մϴ�!!!");
		return "index";
	}

}
