<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>区域操作</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-save.css"></head>
<body>
	<div class="contents">
		<ul class="nav-tabs nav">
			<li>
				<a href="<%=basePath%>account/list">区域列表</a>
			</li>
			<li class="active">
				<a>${not empty account.id?'修改':'添加'}信息</a>
			</li>
		</ul>
		<div class="container saveform">
			<form:form action="${basePath }account/save" modelAttribute="user" class="form-horizontal">
				<form:hidden path="id"/>
				<div class="form-group row">
					<label class="control-label col-2">账户</label>
					<div class="col-8">
						<form:input path="account.username" class="form-control" placeholder="账户" maxlength="20" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">密码</label>
					<div class="col-8">
						<form:password path="account.password" class="form-control" placeholder="密码" maxlength="20" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">姓名</label>
					<div class="col-8">
						<form:input path="name" class="form-control" placeholder="姓名" maxlength="20" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">性别</label>
					<div class="col-8">
						<form:input path="sex" class="form-control" placeholder="性别" maxlength="20" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">年龄</label>
					<div class="col-8">
						<form:input path="age" class="form-control" placeholder="年龄" maxlength="20" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">身份证</label>
					<div class="col-8">
						<form:input path="card" class="form-control" placeholder="身份证" maxlength="20" />
					</div>
				</div>
				<div class="form-group row">
					<div class="radio col-8 col-push-2">
						<input type="submit" class="btn btn-primary" value="保存">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
<%@include file="/WEB-INF/views/include/js.jsp"%>
</html>