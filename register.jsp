<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	//点击 换一张  js 
	function changeImage(){
		document.getElementById("image").src ="${pageContext.request.contextPath }/CheckImageServlet?"+ new Date().getTime();
	}
	
	
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
		
		var repassword = document.getElementById("repassword").value;
		if(password!=repassword){
			alert("两次密码不一致 ...");
			return false;
		}
		
		
		var nickname = document.getElementById("nickname").value;
		if(nickname==""){
			alert("昵称不能为空...");
			return false;
		}
		
		var email = document.getElementById("email").value;
		if(email.match("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")==null){
			// 如果进来, 则说明没有找到 正则表达式的匹配 
			alert("邮箱的格式不正确...");
			return false;
		}
		
		var checkcode = document.getElementById("checkcode").value;
		if(checkcode==""){
			alert("验证码不能为空...");
			return false;
		}
	}
	
</script>
</head>
<body>
	<!-- 注册的页面 -->
	<h3>世纪佳缘网站 注册页面</h3>
	<!-- 注意, 表单的 提交 方式 post  -->
	<font color="red">${message }</font>	
	
	<form action="${pageContext.request.contextPath }/RegisterServlet" onsubmit="return validateForm();" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td>
					<input type="text" name="username" id="username">
				</td>
			</tr>
			<tr>
				<td>密码:</td>
				<td>
					<input type="password" name="password" id="password">
				</td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td>
					<input type="password" name="repassword" id="repassword">
				</td>
			</tr>
			<tr>
				<td>昵称:</td>
				<td>
					<input type="text" name="nickname" id="nickname">
				</td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td>
					<input type="text" name="email" id="email">
				</td>
			</tr>
			<tr>
				<td>请输入验证码:</td>
				<td>
					<input type="text" name="checkcode" id="checkcode">
					
					<!--                                                                  -->
					<!-- 从 servlet 中请求图片，   注意建立servlet的时候需要清楚  servlet 的 name， 然后才能请求的到-->
					<!--                                                                  -->
					<img src="${pageContext.request.contextPath }/CheckImageServlet" style="cursor: pointer" 
					onclick="changeImage();" id="image">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="注册"> 
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>