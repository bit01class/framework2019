package com.bit.framework;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.controller.AddController;
import com.bit.controller.IndexController;
import com.bit.controller.ListController;
import com.bit.controller.MainController;

public class DispatcherServlets extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doDo(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doDo(req,resp);
	}
	
	public void doDo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String root=req.getContextPath();
		String path=req.getRequestURI().substring(root.length());
		
		Controller controller =null;
		
		if(path.equals("/index.bit")){
			controller = new IndexController();
		}else if(path.equals("/main.bit")){
			controller = new MainController();
		}else if(path.equals("/list.bit")){
			controller = new ListController();
		}else if(path.equals("/add.bit")){
			controller = new AddController();
		}else if(path.equals("/insert.bit")){
			controller = new com.bit.controller.InsertController();
		}
		
		String viewName=null;
		try {
			viewName = controller.execute(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// viewResolver
		
		if(viewName.startsWith("redirect:")){
			resp.sendRedirect(root+viewName.substring("redirect:".length()));
		}else{
		String prefix="/WEB-INF/view/";
		String suffix=".jsp";
		
		viewName=prefix+viewName+suffix;
		req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
	
}


























