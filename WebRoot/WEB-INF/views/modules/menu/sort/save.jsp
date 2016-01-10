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
		<ul class="nav-tabs nav">
			<li><a href="<%=basePath%>menu/sort/list">景点列表</a></li>
			<li class="active"><a>${not empty menusort.id?'修改':'添加'}信息</a></li>
		</ul>
		<div class="container saveform">
			<form:form action="${basePath }menu/sort/save" modelAttribute="menusort" class="form-horizontal"
				enctype="multipart/form-data">
				<form:hidden path="id" />
				<div class="form-group row">
					<label class="control-label col-2">菜单名称</label>
					<div class="col-8">
						<form:input path="name" class="form-control required" placeholder="菜单名称" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">排序</label>
					<div class="col-8">
						<form:input path="ord" class="form-control required" placeholder="排序" />
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