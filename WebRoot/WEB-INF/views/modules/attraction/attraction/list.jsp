<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>城市列表</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-list.css"></head>
<body>
	<div class="contents">
		<ul class="nav-tabs nav">
			<li class="active">
				<a>景点列表</a>
			</li>
			<li>
				<a href="<%=basePath%>attraction/edit">添加信息</a>
			</li>
		</ul>
		<div class="search">
			<form:form id="form" class="form-horizontal" action="${basePath }attraction/list" method="get" modelAttribute="attraction">
				<input type="hidden" id="pageNum" name="pageNum">
				<%-- <div class="form-group row">
					<label class="control-label col-3">区域名称</label>
					<div class="col-7">
						<select class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-1"
							linkage-url="${basePath }position/continentSelections">
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-3">国家名称</label>
					<div class="col-7">
						<select class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-2"
							linkage-url="${basePath }position/nationSelections">
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-3">省会名称</label>
					<div class="col-7">
						<select class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-3"
							linkage-url="${basePath }position/provinceSelections">
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-3">城市名称</label>
					<div class="col-7">
						<form:select path="city.id" class="select2 linkage" linkage-label="name" linkage-value="id"
							linkage-num="1-4" linkage-url="${basePath }position/citySelections">
						</form:select>
					</div>
				</div> --%>
				<div class="form-group">
					<label class="control-label col-3">城市名称</label>
					<div class="col-7">
						<input name="name" placeholder="城市名称" class="form-control" value="${requestScope.attraction.name }"/></div>
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
						<th>城市/县名称</th>
						<th>景区</th>
						<th>标题</th>
						<th>是否隐藏</th>
						<th>适合人群</th>
						<th>景点类型</th>
						<th>景区地址</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${requestScope.page.list }" var="attraction" varStatus="s">
						<tr>
							<td>${s.index+1 }</td>
							<td>${attraction.city.name }</td>
							<td>${attraction.name }</td>
							<td>${attraction.title}</td>
							<td>${attraction.hide}</td>
							<td>${attraction.forPeople}</td>
							<td>${attraction.type}</td>
							<td>${attraction.place}</td>
							<td>
								<a href="<%=basePath%>attraction/edit?id=${attraction.id}">修改</a>
								<a href="<%=basePath%>attraction/del?id=${attraction.id}">删除</a>
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