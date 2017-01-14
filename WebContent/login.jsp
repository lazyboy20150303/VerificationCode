<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function refreshcode(){
		var date=new Date().getTime();//确保浏览器重新发送请求
		document.getElementById("vcode").src="<%=request.getContextPath() %>/servlet/ImageServlet?d="+date;
	}
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/servlet/VerifyServlet" method="post">
	<input type="text" name="verificationCode"/>
	<img alt="验证码" id="vcode" src="<%=request.getContextPath() %>/servlet/ImageServlet">
	<a href="javascript:refreshcode()">刷新</a>
	<br>
	<input type="submit" value="提交">
	</form>
</body>
</html>