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
		<ol class="breadcrumb lan">
			<li>
				<a href="<%=basePath %>account/list">账户列表</a>
			</li>
			<li>
				<a href="<%=basePath %>accountrole/list/${accountRole.account.id}">账户角色列表</a>
			</li>
			<li class="active">添加角色</li>
		</ol>
		<ul class="nav-tabs nav">
			<li>
				<a href="<%=basePath%>dict/list">区域列表</a>
			</li>
			<li class="active">
				<a>${not empty dictionary.id?'修改':'添加'}信息</a>
			</li>
		</ul>
		<div class="container saveform">
			<form:form action="${basePath }dict/save/${accountRole.account.id}" modelAttribute="accountRole" class="form-horizontal">
				<form:hidden path="id"/>
				<div class="form-group row">
					<label class="control-label col-2">类型</label>
					<div class="col-8">
						<form:select path="role.id" class="select2" >
							<form:option value="" label=""/>
							<form:options items="${requestScope.permissionsList }" itemLabel="name" itemValue="id"/>
						</form:select>
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