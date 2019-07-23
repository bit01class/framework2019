package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;
import com.bit.model.Bbs02Dao2;

public class DetailController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws SQLException {
		int num=Integer.parseInt(req.getParameter("idx"));
		Bbs02Dao2 dao=new Bbs02Dao2();
		req.setAttribute("bean", dao.getOne(num));
		return "bbs/detail";
	}

}
