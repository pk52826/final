package com.amazon.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.service.AmazonService;
import com.amazon.service.AmazonServiceInterface;
import com.amazon.entity.Amazon1Customer;

public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/Html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		String option=request.getParameter("ac");
		if(option.equals("register")) {
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
		
		Amazon1Customer ac=new Amazon1Customer();
		ac.setName(name);
		ac.setPass(pass);
		ac.setEmail(email);
		ac.setAddress(address);
		AmazonServiceInterface ae=AmazonService.createServiceObject();
		int i=ae.createProfile(ac);
		if(i>0) {
			out.println("profile created");
		}
		else
		{
			out.println("profile not created");
		}
		
		
	}}}


