package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;

public class ListController  implements Controller{

	public String execute(HttpServletRequest req){
//		req.setAttribute("alist", dao);
		return "bbs/list";
	}
}
