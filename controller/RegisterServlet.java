package com.pengyang.user.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.pengyang.user.model.User;
import com.pengyang.user.model.UserService;

public class RegisterServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get captcha 
				String checkcode = request.getParameter("checkcode");
				
				// get the captcha in session
				String codeInSession = (String) request.getSession().getAttribute("checkcode_session");
				
				// check if the code is null in case the skiped js check
				if(checkcode == null || !checkcode.equalsIgnoreCase(codeInSession))	
				{
					request.setAttribute("message", "wrong code"); //  request attribute
					
					request.getRequestDispatcher("/register.jsp").forward(request, response);
					return;
				}
				
				// register logic
				/*String parameter = request.getParameter("username");
				String parameter = request.getParameter("username");
				String parameter = request.getParameter("username");
				String parameter = request.getParameter("username");
				
				User user = new User();
				user。set
				*/
				
				//apache beanUtils encapsulate javabean
				
				
				User user = new User();
				// （request.getParameterMap()）
				
				try {
					BeanUtils.populate(user, request.getParameterMap());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(user.getNickname());
				
				// check if registered successfully
				// rertu int / cases
				
				UserService us = new UserService();
				int feedback = us.regist(user);
				
				switch(feedback)
				{
				case 1:
					//username existed
					request.setAttribute("message", "对不起，用户名已经被占用，请换一个");
			
					request.getRequestDispatcher("/register.jsp").forward(request, response);
					break;
				case 2:
					//email address existed
					request.setAttribute("message", "对不起，Email已经被占用，请换一个");
			
					request.getRequestDispatcher("/register.jsp").forward(request, response);
					break;
					
				case 3:
					//registered successful then direct to a  new jsp page
					// put info into session, then keep login in
					User loginUser = user;
					request.getSession().setAttribute("loginUser", loginUser);
					request.getRequestDispatcher("/message.jsp").forward(request, response);
				}
				 
			    
				
	}
}

