<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
  
  <c:if test= "${not empty loginUser}">
    <font color=red>欢迎您,  ${loginUser.getNickname()}</font>  <br>
    <!-- 注销，传到Logout servlet --> 
    <a href="${pageContext.request.contextPath}/Logout">注销</a> &nbsp;&nbsp;&nbsp;
  </c:if>
  
  <c:if test= "${empty loginUser}">
     对不起，你还没有登陆</br>
     <a href="${pageContext.request.contextPath}/login.jsp ">去登陆</a> &nbsp;&nbsp;&nbsp;
     <a href="${pageContext.request.contextPath}/register.jsp ">去注册</a>  &nbsp;&nbsp;&nbsp;
  </c:if>
  
  </body>
</html>
