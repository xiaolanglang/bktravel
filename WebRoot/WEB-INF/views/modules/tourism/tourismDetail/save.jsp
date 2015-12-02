<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>线路操作</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-save.css">
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>common/stepBar.css">
	<script type="text/javascript" src="<%=jsPath%>common/jquery.stepBar.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#stepBar").stepBarInit({step:4});
		})
	</script>
</head>
<body>
	<div class="contents">
		<ul class="nav-tabs nav">
			<li>
				<a href="<%=basePath%>tourism/list">线路列表</a>
			</li>
			<li class="active">
				<a>${not empty tourismDetail.id?'修改':'添加'}信息</a>
			</li>
		</ul>
		<%@include file="/WEB-INF/views/modules/tourism/tourism/include/stepBar.jsp" %>
		<div class="container saveform">
			<form:form action="${basePath }tourismDetail/save" modelAttribute="tourismDetail" class="form-horizontal">
				<form:hidden path="id"/>
				<div class="form-group row">
					<label class="control-label col-2">行程安排</label>
					<div class="col-8">
						<form:input path="id" class="form-control" placeholder="行程安排" maxlength="15" />
					</div>
				</div>
				<div class="form-group row">
					<div class="radio col-8 col-push-2">
						<input type="submit" class="btn btn-primary" value="下一步">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>