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
		<ul class="nav-tabs nav">
			<li class="active"><a>景点列表</a></li>
			<li><a href="<%=basePath%>menu/sort/edit">添加信息</a></li>
		</ul>
		<div class="search">
			<form:form id="form" class="form-horizontal" action="${basePath }menu/sort/list" method="post"
				modelAttribute="menusort">
				<input type="hidden" id="pageNum" name="pageNum">
				<div class="form-group">
					<label class="control-label col-3">菜单名称</label>
					<div class="col-7">
						<input name="title" placeholder="菜单名称" class="form-control"
							value="${requestScope.menusort.name }" />
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
						<th>菜单名称</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${requestScope.list }" var="menusort" varStatus="s">
						<tr>
							<td>${s.index+1 }</td>
							<td>${menusort.name}</td>
							<td><a href="<%=basePath%>menu/sort/edit?id=${menusort.id}">修改</a> <a
								href="<%=basePath%>menu/sort/childmenulist/${menusort.id}">下级菜单</a>  <a
								href="<%=basePath%>menu/sort/del?id=${menusort.id}">删除</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
<%@include file="/WEB-INF/views/include/js.jsp"%>
</html>