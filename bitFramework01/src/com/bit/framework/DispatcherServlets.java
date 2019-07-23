package com.bit.framework;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlets extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		Properties prop=new Properties();
		Class<? extends DispatcherServlets> clz = getClass();
		ClassLoader loader = clz.getClassLoader();
		InputStream is = loader.getResourceAsStream("bit.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Set keys = prop.keySet();
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()){
			String key = ite.next();
			String clInfo=prop.getProperty(key);
			BitHandlerMapping.setMap(key, clInfo);
		}
	}

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
		
		// handleMapping
		
		Controller controller =null;
		
		controller=BitHandlerMapping.getController(path);
		
		String viewName=null;
		try {
			viewName = controller.execute(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// viewResolver
		String prefix="/WEB-INF/view/";
		String suffix=".jsp";
		
		if(viewName.startsWith("redirect:")){
			resp.sendRedirect(root+viewName.substring("redirect:".length()));
		}else{
			viewName=prefix+viewName+suffix;
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
	
}


























