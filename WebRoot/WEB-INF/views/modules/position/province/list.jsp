<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>省会列表</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-list.css"></head>
<body>
	<div class="contents">
		<ul class="nav-tabs nav">
			<li class="active">
				<a>省会列表</a>
			</li>
			<li>
				<a href="<%=basePath%>province/edit">添加信息</a>
			</li>
		</ul>
		<div class="search">
			<form:form id="form" class="form-horizontal" action="${basePath }province/list" method="post" modelAttribute="province">
				<input type="hidden" id="pageNum" name="pageNum">
				<div class="form-group">
					<label class="control-label col-4">区域名称</label>
					<div class="col-7">
						<form:select path="nation.continent.id" class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-1" linkage-url="${basePath }position/continentSelections">
							<form:option value="" label=""/>
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-4">国家名称</label>
					<div class="col-7">
						<form:select path="nation.id" class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-2" linkage-url="${basePath }position/nationSelections">
							<form:option value="" label=""/>
						</form:select>	
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-4">省会名称</label>
					<div class="col-7">
						<form:input path="name" placeholder="省会名称" class="form-control"/></div>
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
						<th>国家</th>
						<th>省会</th>
						<th>英文</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${requestScope.page.list }" var="province" varStatus="s">
						<tr>
							<td>${s.index+1 }</td>
							<td>${province.nation.continent.name}</td>
							<td>${province.nation.name }</td>
							<td>${province.name }</td>
							<td>${province.nameEn }</td>
							<td>
								<a href="<%=basePath%>province/edit?id=${province.id}">修改</a>
								<a href="<%=basePath%>province/del?id=${province.id}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="btn-group page">${msg:page(page)}</div>
		</div>
	</div>
</body>
<%-- <script type="text/javascript" src="<%=jsPath%>common/requirejs_2.1.11.js" data-main="<%=jsPath%>modules/home/main.js"></script> --%>
</html>