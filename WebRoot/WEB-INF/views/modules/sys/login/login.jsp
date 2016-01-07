<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>爱旅游后台登录</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-list.css">
	<link type="text/css" href="<%=cssPath%>modules/login/signin.css" rel="stylesheet">
	<script language="JavaScript">
		if (window != top)
			top.location.href = location.href;
	</script>
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
			<input value="admin" name="username" type="text" class="form-control" placeholder="用户名" required  />
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
		</form>
	</div>
</body>
</html>