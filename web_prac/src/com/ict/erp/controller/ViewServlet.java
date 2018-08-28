package com.ict.erp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.utils.Utils;


@WebServlet(
		urlPatterns = "/views/*",
		name = "ViewServlet",
		loadOnStartup = 1
		)

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String rPath = request.getContextPath();
		
		uri = uri.replaceAll(rPath, "");
		
		uri = Utils.makeUri(uri);
		
		System.out.println(uri);
		
		doService(request,response,uri);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	public void doService(HttpServletRequest request, HttpServletResponse response,String uri) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
		
	}
}
