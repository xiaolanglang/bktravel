<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<title>城市操作</title>
<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-save.css">
</head>
<body>
	<div class="contents">
		<ol class="breadcrumb lan">
			<li>
				<a href="<%=basePath%>menu/sort/list">父级菜单列表</a>
			</li>
			<li class="active">子栏目操作</li>
		</ol>
		<ul class="nav-tabs nav">
			<li><a href="<%=basePath%>menu/sort/childmenulist/${request.id}">景点列表</a></li>
			<li class="active"><a>${not empty menusort.id?'修改':'添加'}信息</a></li>
		</ul>
		<div class="container saveform">
			<form:form action="${basePath }menu/sort/childmenusave" modelAttribute="menusort" class="form-horizontal"
				enctype="multipart/form-data">
				<form:hidden path="id" />
				<input type="hidden" value="${requestScope.parentId}" name="parent.id">
				<div class="form-group row">
					<label class="control-label col-2">栏目名称</label>
					<div class="col-8">
						<form:input path="name" class="form-control required" placeholder="栏目名称" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">英文栏目名称</label>
					<div class="col-8">
						<form:input path="nameEn" class="form-control required" placeholder="英文栏目名称" />
					</div>
				</div>
				<div class="form-group row">
					<div class="radio col-8 col-push-2">
						<input type="submit" class="btn btn-primary" value="保存">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
<%@include file="/WEB-INF/views/include/js.jsp"%>
<script type="text/javascript" src="<%=jsPath%>modules/menu/find/menuFind.js"></script>
</html>