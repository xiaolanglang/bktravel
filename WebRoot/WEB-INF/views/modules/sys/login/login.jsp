<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>爱旅游后台登录</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-list.css">

	<link type="text/css" href="<%=cssPath%>modules/login/signin.css" rel="stylesheet">
</head>
<body>
	<div class="signin">
		<div class="signin-head">
			<div class="round head-img">
				<span class="glyphicon glyphicon-user"></span>
				<!-- <img src="../../img/login/test/head_120.png" alt=""> -->
			</div>
		</div>
		<form class="form form-signin" method="post" action="<%=bpath%>login">
			<input value="test" name="username" type="text" class="form-control" placeholder="用户名" required  />
			<input value="123456" name="password" type="password" class="form-control" placeholder="密码" required />
			<input type="submit" class="btn btn-yellow" value="登录">
			<div class="checkbox-inline">
				<label>
					<input type="checkbox" value="remember-me">记住我
				</label>
				<label class="forget">
					<a href="##">忘记密码？</a>
				</label>
			</div>
			<a id="myModal">Click me to open a modal window!</a>
		</form>
	</div>
</body>
<%@include file="/WEB-INF/views/include/js.jsp"%>
<script type="text/javascript">
$(function(){
	
	new jBox("Notice",{
	    content: 'This is my modal wind121212ow',
	    trigger:"click",
	    delayClose:1
	});
})
</script>
</html>