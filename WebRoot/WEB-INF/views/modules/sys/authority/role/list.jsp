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
				<a href="<%=basePath%>role/edit">添加信息</a>
			</li>
		</ul>
		<div class="search">
			<form:form class="form-horizontal" action="${basePath }role/list" method="post" modelAttribute="role" id="form">
				<input type="hidden" id="pageNum" name="pageNum">
				<div class="form-group">
					<label class="control-label col-4">名称</label>
					<div class="col-7">
						<form:input path="name" class="form-control"  placeholder="角色名称"/>
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
						<th>名称</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${requestScope.page.list }" var="role" varStatus="s">
						<tr>
							<td>${s.index+1 }</td>
							<td>${role.name }</td>
							<td>
								<a href="<%=basePath%>role/edit?id=${role.id}">修改</a>
								<a href="<%=basePath%>rolepermission/list/${role.id}">分配权限</a>
								<a href="<%=basePath%>role/del?id=${role.id}">删除</a>
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