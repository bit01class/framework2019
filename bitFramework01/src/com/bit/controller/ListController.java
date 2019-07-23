package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;
import com.bit.model.entity.Bbs02Dao1;

public class ListController  implements Controller{

	public String execute(HttpServletRequest req) throws SQLException{
		Bbs02Dao1 dao=new Bbs02Dao1();
		req.setAttribute("alist", dao.getList());
		return "bbs/list";
	}
}
