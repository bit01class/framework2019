package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;

public class MainController  implements Controller{
	
	public String execute(HttpServletRequest req){
		return "main";
	}
}
