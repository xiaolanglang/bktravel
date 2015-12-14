<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>区域列表</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-list.css">
</head>
<body>
	<div class="contents">
		<ul class="nav-tabs nav">
			<li class="active">
				<a>区域列表</a>
			</li>
			<li>
				<a href="<%=basePath%>permissions/edit">添加信息</a>
			</li>
		</ul>
		<div class="search">
			<form:form class="form-horizontal" action="${basePath }permissions/list" method="post" modelAttribute="permissions" id="form">
				<input type="hidden" id="pageNum" name="pageNum">
				<div class="form-group">
					<label class="control-label col-4">权限名称</label>
					<div class="col-7">
						<form:input path="permission" class="form-control"  placeholder="权限名称"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-6">
						<input type="submit" class="btn btn-primary col-push-1" value="查询">
						<input type="reset" class="btn btn-primary" value="重置">
					</div>
				</div>
			</form:form>
		</div>
		<div class="content" ng-controller="userCtrl">
			<div class="table-responsive">
				<table class="table table-hover table-border table-striped table-title">
					<tr>
						<th>序号</th>
						<th>权限名称</th>
						<th>权限</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${requestScope.page.list }" var="permissions" varStatus="s">
						<tr>
							<td>${s.index+1 }</td>
							<td>${permissions.name }</td>
							<td>${permissions.permission }</td>
							<td>
								<a href="<%=basePath%>permissions/edit?id=${permissions.id}">修改</a>
								<a href="<%=basePath%>permissions/del?id=${permissions.id}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="btn-group page">${msg:page(page)}</div>
		</div>
	</div>
</body>
<%@include file="/WEB-INF/views/include/js.jsp"%>
</html>