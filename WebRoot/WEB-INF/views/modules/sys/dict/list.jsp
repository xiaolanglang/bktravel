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
				<a href="<%=basePath%>dict/edit">添加信息</a>
			</li>
		</ul>
		<div class="search">
			<form:form class="form-horizontal" action="${basePath }dict/list" method="post" modelAttribute="dictionary" id="form">
				<input type="hidden" id="pageNum" name="pageNum">
				<div class="form-group">
					<label class="control-label col-4">类型</label>
					<div class="col-7">
						<form:select path="type" class="select2">
							<form:option value=""></form:option>
							<form:options items="${requestScope.types }" />
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-4">描述</label>
					<div class="col-7">
						<form:input path="description" class="form-control"  placeholder="描述"/>
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
						<th>类型</th>
						<th>标签</th>
						<th>描述</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${requestScope.page.list }" var="dictionary" varStatus="s">
						<tr>
							<td>${s.index+1 }</td>
							<td>${dictionary.type }</td>
							<td>${dictionary.label }</td>
							<td>${dictionary.description }</td>
							<td>
								<a href="<%=basePath%>dict/edit?id=${dictionary.id}">修改</a>
								<a href="<%=basePath%>dict/del?id=${dictionary.id}">删除</a>
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