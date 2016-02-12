package com.pengyang.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;

import com.pengyang.user.model.User;
import com.pengyang.user.model.UserService;
import com.pengyang.utils.XMLUtils;

public class LoginCheck extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  // get info from form
		  String username = request.getParameter("username");
		  String password = request.getParameter("password");
		  request.getParameter("remenber");
		  
		  //check if data in xml
		  UserService login = new UserService();
		  User loginUser = login.loginCheck(username, password);
		  
		  
		  if(loginUser != null)
			{
			   //  set loginUser in Session
			   request.getSession().setAttribute("loginUser", loginUser);
			   
			   // check if user checked the save username and password
			   //  getParrameter.
			   if("on".equals(request.getParameter("remember")))
			   {
				// encode url
					 String name = loginUser.getUsername();
					 String encodedName = URLEncoder.encode(name, "UTF-8");  // %AC%DF
				   
				   
					
					//wrote username and password cookie 
				Cookie usernameCookie = new Cookie("username",encodedName);
				usernameCookie.setMaxAge(60*60*24);
				usernameCookie.setPath("/");
			    response.addCookie(usernameCookie);
				   
			   Cookie passwordCookie = new Cookie("password", loginUser.getPassword());
			   //set cookie time out
			   passwordCookie.setMaxAge(60*60*24);
			   passwordCookie.setPath("/");
			   response.addCookie(passwordCookie); 
			   }

				// redirect to browser and send request
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
			else
			{
				request.setAttribute("message", "Sorry, wrong username or password");
				// dispacher (do not send request to browser)
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}
		
				
			
		  



