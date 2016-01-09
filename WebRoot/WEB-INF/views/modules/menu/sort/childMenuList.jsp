<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<title>城市列表</title>
<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-list.css">
</head>
<body>
	<div class="contents">
		<ol class="breadcrumb lan">
			<li>
				<a href="<%=basePath%>menu/sort/list">父级菜单列表</a>
			</li>
			<li class="active">子栏目列表</li>
		</ol>
		<ul class="nav-tabs nav">
			<li class="active"><a>景点列表</a></li>
			<li><a href="<%=basePath%>menu/sort/childmenuedit/${requestScope.parentId}">添加信息</a></li>
		</ul>
		<div class="search">
			<form:form id="form" class="form-horizontal" action="${basePath }menu/sort/childmenulist/${requestScope.parentId}" method="post"
				modelAttribute="menusort">
				<input type="hidden" value="${param.id}" name="id">
				<div class="form-group">
					<label class="control-label col-3">菜单名称</label>
					<div class="col-7">
						<form:input path="name" placeholder="菜单名称" class="form-control"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-6">
						<input type="submit" class="btn btn-primary col-push-1" value="查询"> <input
							type="reset" class="btn btn-primary" value="重置">
					</div>
				</div>
			</form:form>
		</div>
		<div class="content" ng-controller="userCtrl">
			<div class="table-responsive">
				<table class="table table-hover table-border table-striped table-title">
					<tr>
						<th>序号</th>
						<th>父菜单名称</th>
						<th>栏目名称</th>
						<th>栏目英文名称</th>
						<th>搜索关键词</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${requestScope.page.list }" var="menusort" varStatus="s">
						<tr>
							<td>${s.index+1 }</td>
							<td>${menusort.parent.name}</td>
							<td>${menusort.name}</td>
							<td>${menusort.nameEn}</td>
							<td>${menusort.keyWord}</td>
							<td><a href="<%=basePath%>menu/sort/childmenuedit/${requestScope.parentId}?id=${menusort.id}">修改</a>  <a
								href="<%=basePath%>menu/sort/childmenudel/${requestScope.parentId}?id=${menusort.id}">删除</a></td>
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