package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;
import com.bit.model.entity.Bbs02Dao1;

public class DetailController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws SQLException {
		int num=Integer.parseInt(req.getParameter("idx"));
		Bbs02Dao1 dao=new Bbs02Dao1();
		req.setAttribute("bean", dao.selectOne(num));
		return "bbs/detail";
	}

}
