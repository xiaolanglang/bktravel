<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>线路列表</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-list.css"></head>
<body>
	<div class="contents">
		<ul class="nav-tabs nav">
			<li class="active">
				<a>线路列表</a>
			</li>
			<li>
				<a href="<%=basePath%>tourism/edit">添加信息</a>
			</li>
		</ul>
		<div class="search">
			<form:form id="form" class="form-horizontal" action="${basePath }tourism/list" method="post" modelAttribute="tourism">
				<input type="hidden" id="pageNum" name="pageNum">
				<div class="form-group">
					<label class="control-label col-3">线路名称</label>
					<div class="col-7">
						<form:input path="title" placeholder="线路名称" class="form-control"/></div>
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
						<th>旅游线路标题</th>
						<th>旅游线路副标题</th>
						<th>是否隐藏</th>
						<th>旅游线路类型</th>
						<th>天数</th>
						<th>成人原价</th>
						<th>成人现价</th>
						<th>折扣</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${requestScope.page.list }" var="tourism" varStatus="s">
						<tr>
							<td>${s.index+1 }</td>
							<td>${tourism.title }</td>
							<td>${tourism.subtitle }</td>
							<td>${msg:getDictLabel(tourism.hide,"hide")}</td>
							<td>${msg:getDictLabel(tourism.type,"tourism_types")}</td>
							<td>${tourism.days }</td>
							<td>${tourism.adultPrice }</td>
							<td>${tourism.adultOriginalPrice }</td>
							<td>${tourism.discount }</td>
							<td>
								<a href="<%=basePath%>tourism/publish?id=${tourism.id}">发布</a>
								<a href="<%=basePath%>tourism/edit?id=${tourism.id}">修改</a>
								<a href="<%=basePath%>tourism/del?id=${tourism.id}">删除</a>
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