<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>线路操作</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-save.css">
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>common/stepBar.css">
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/tourism/tourism/img_info/img_info.css">
	<script type="text/javascript" src="<%=jsPath%>common/jquery.stepBar.js"></script>
</head>
<body ng-controller="AppController">
	<div class="contents">
		<ul class="nav-tabs nav">
			<li>
				<a href="<%=basePath%>tourism/list">线路列表</a>
			</li>
			<li class="active">
				<a>${not empty tourism.id?'修改':'添加'}信息</a>
			</li>
		</ul>
		<%@include file="/WEB-INF/views/modules/tourism/tourism/include/stepBar.jsp" %>
		<div class="container saveform">
			<%@include file="/WEB-INF/views/modules/tourism/tourism/include/imgBox.jsp" %>
			<%@include file="/WEB-INF/views/modules/tourism/tourism/include/fileUpload.jsp" %>
		</div>
		<a href="<%=basePath %>tourismDetail/save_detail/${requestScope.tourism.id}" class="btn btn-primary col-push-1">下一步</a>
	</div>
</body>
<script type="text/javascript" src="<%=jsPath%>common/requirejs_2.1.11.js" 
		data-main="<%=jsPath %>modules/tourism/tourism/img_info/main.js"></script>
<script type="text/javascript">
	$(function(){
		$("#stepBar").stepBarInit({step:3});
	})
</script>
</html>