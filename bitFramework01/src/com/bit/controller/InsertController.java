package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;
import com.bit.model.entity.Bbs02Dao1;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws SQLException {
		String name=req.getParameter("name");
		String sub=req.getParameter("sub");
		String content=req.getParameter("content");
		Bbs02Dao1 dao=new Bbs02Dao1();
		dao.insertOne(name,sub,content);
		return "redirect:/list.bit";
	}

}
