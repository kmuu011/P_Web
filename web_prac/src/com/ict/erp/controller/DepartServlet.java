package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.service.UserService;
import com.ict.erp.service.impl.UserServiceImpl;
import com.ict.erp.utils.Utils;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.PageInfo;


@WebServlet(
		urlPatterns = "/depart/*",
		name = "DepartServlet",
		loadOnStartup = 1
		)
public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String rPath = request.getContextPath();
		String cmd = Utils.getCmd(uri);
		UserService us = new UserServiceImpl();
		
		uri = uri.replaceAll(rPath, "");
		
		try {
			
			if(cmd.equals("departList")) {
				String sch = request.getParameter("search");
				String op = request.getParameter("op");
				String pageStr = request.getParameter("page");
				DepartInfo di = new DepartInfo();
				PageInfo pi = new PageInfo();
				
				if(pageStr==null || pageStr.trim().equals("")) {
					pageStr = "1";
				}
				
				if(sch != null && !sch.trim().equals("")) {
					pi.setSch(sch);
					pi.setOp(op);
				}
				
				pi.setPage(Integer.parseInt(pageStr));
				
				di.setPageInfo(pi);
				
				request.setAttribute("di", us.getDepartInfo(di));
				request.setAttribute("pi", pi);
				
			}else if(cmd.equals("insert")) {
				List<DepartInfo> departInfoList = new ArrayList<DepartInfo>();
				String[] diCode = request.getParameterValues("diCode");
				String[] diName = request.getParameterValues("diName");
				String[] diDesc = request.getParameterValues("diDesc");
				
				for(int i=0; i<diCode.length ; i++) {
					DepartInfo di = new DepartInfo(0,diCode[i], diName[i], diDesc[i]);
					departInfoList.add(di);
				}
				
				request.setAttribute("result", us.getInsertResult(departInfoList));
				
				uri = "/depart/departList";
			} else if(cmd.equals("remove")) {
				String[] chk = request.getParameterValues("chk");
				
				request.setAttribute("resultD", us.getRemoveResult(chk));
				
				uri = "/depart/departList";
				
			} else if(cmd.equals("departView")) {
				int diNum = Integer.parseInt(request.getParameter("diNum"));
				
				request.setAttribute("di", us.getView(diNum));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		uri = "/views" + uri;
		doService(request, response, uri);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	public void doService(HttpServletRequest request, HttpServletResponse response,String uri) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
		
	}
}
