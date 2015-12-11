<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>国家列表</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-list.css"></head>
<body>
	<div class="contents">
		<ul class="nav-tabs nav">
			<li class="active">
				<a>国家列表</a>
			</li>
			<li>
				<a href="<%=basePath%>nation/edit">添加信息</a>
			</li>
		</ul>
		<div class="search">
			<form:form id="form" class="form-horizontal" action="${basePath }nation/list" method="post" modelAttribute="nation">
				<input type="hidden" id="pageNum" name="pageNum">
				<div class="form-group">
					<label class="control-label col-4">区域名称</label>
					<div class="col-7">
						<form:select path="continent.id" class="select2" >
							<form:option value="" label=""/>
							<form:options items="${requestScope.continents }" itemLabel="name" itemValue="id"/>
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-4">国家名称</label>
					<div class="col-7">
						<form:input placeholder="国家名称" class="form-control" path="name"/></div>
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
						<th>区域</th>
						<th>国家名称</th>
						<th>英文名称</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${requestScope.page.list }" var="nation" varStatus="s">
						<tr>
							<td>${s.index+1 }</td>
							<td>${nation.continent.name }</td>
							<td>${nation.name }</td>
							<td>${nation.nameEn }</td>
							<td>
								<a href="<%=basePath%>nation/edit?id=${nation.id}">修改</a>
								<a href="<%=basePath%>nation/del?id=${nation.id}">删除</a>
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