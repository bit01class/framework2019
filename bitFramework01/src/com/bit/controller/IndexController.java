package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;

public class IndexController implements Controller{

	public String execute(HttpServletRequest req) {
		req.setAttribute("msg", "ȯ���մϴ�!!!");
		return "index";
	}

}
