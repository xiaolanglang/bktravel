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
			<li><a href="<%=basePath%>menu/find/edit">添加信息</a></li>
		</ul>
		<div class="search">
			<form:form id="form" class="form-horizontal" action="${basePath }menu/find/list" method="post"
				modelAttribute="menuFind">
				<input type="hidden" id="pageNum" name="pageNum">
				<div class="form-group">
					<label class="control-label col-3">主标题</label>
					<div class="col-7">
						<input name="title" placeholder="主标题" class="form-control"
							value="${requestScope.menuFind.title }" />
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
						<th>标题</th>
						<th>副标题</th>
						<th>关键词</th>
						<th>是否隐藏</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${requestScope.page.list }" var="menuFind" varStatus="s">
						<tr>
							<td>${s.index+1 }</td>
							<td>${menuFind.title}</td>
							<td>${menuFind.subTitle}</td>
							<td>${menuFind.keyword}</td>
							<td>${msg:getDictLabel(menuFind.hide,"hide")}</td>
							<td><a href="<%=basePath%>menu/find/edit?id=${menuFind.id}">修改</a> <a
								href="<%=basePath%>menu/find/del?id=${menuFind.id}">删除</a></td>
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