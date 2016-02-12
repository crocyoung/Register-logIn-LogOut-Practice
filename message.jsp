<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="5 ;url = http://localhost:8080/RegisterLogin/index.jsp">
<title>Insert title here</title>
</head>
<body>

      恭喜您， 注册成功。 页面将在 <font color=orange id="number"></font> 秒钟 后跳转 到主页面，如果为跳转请 点击 <a href="http://localhost:8080/RegisterLogin/index.jsp">跳转</a> 


<script>
var start = 5;
var step = -1;
function count()
{
	document.getElementById("number").innerHTML = start;
	start += step;
	if(start < 0)
		start = 5;
	setTimeout("count()",1000);
}
window.onload = count;
</script>

</body>
</html>