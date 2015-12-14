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
				<a href="<%=basePath%>permissions/list">区域列表</a>
			</li>
			<li class="active">
				<a>${not empty permissions.id?'修改':'添加'}信息</a>
			</li>
		</ul>
		<div class="container saveform">
			<form:form action="${basePath }permissions/save" modelAttribute="permissions" class="form-horizontal">
				<form:hidden path="id"/>
				<div class="form-group row">
					<label class="control-label col-2">名称</label>
					<div class="col-8">
						<form:input path="name" class="form-control" placeholder="名称" maxlength="20" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">权限</label>
					<div class="col-8">
						<form:input path="permission" class="form-control" placeholder="权限" maxlength="20" />
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