<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	
	
	
	
	function validateForm(){
		
		// 拿到 用户名 
		var username = document.getElementById("username").value;
		
		if(username==""){
			alert("用户名不能为空...");
			return false;
		}
		
		// 拿到 密码
		var password = document.getElementById("password").value;
		
		if(password==""){
			alert("密码不能为空...");
			return false;
		}

}	
</script>



  <h3>用户的登录界面</h3>
  <font color="red">${message }</font>
  <form action="${pageContext.request.contextPath}/LoginCheck" onsubmit="return validateForm();" method = "post">
   用户名<input type="text" name = "username" id="username" value="${cookie.username.value}"></br>
   密码：<input type="password" name = "password" id="password"  value="${cookie.password.value}"></br>
   记住用户名密码:<input type="checkbox" name = "remember" value ="on"></br>
   <input type="submit" value="提交">
</form>




</body>
</html>