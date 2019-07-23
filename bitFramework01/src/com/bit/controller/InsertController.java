package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;
import com.bit.model.Bbs02Dao2;
import com.bit.model.entity.Bbs02Vo;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws SQLException {
		String name=req.getParameter("name");
		String sub=req.getParameter("sub");
		String content=req.getParameter("content");
		Bbs02Dao2 dao=new Bbs02Dao2();
		
		Bbs02Vo bean=new Bbs02Vo();
		bean.setSub(sub);
		bean.setName(name);
		bean.setContent(content);
		
		dao.addOne(bean);
		return "redirect:/list.bit";
	}

}
