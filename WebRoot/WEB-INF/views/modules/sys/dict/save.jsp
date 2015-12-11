<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>区域操作</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-save.css"></head>
<body>
	<div class="contents">
		<ul class="nav-tabs nav">
			<li>
				<a href="<%=basePath%>dict/list">区域列表</a>
			</li>
			<li class="active">
				<a>${not empty dictionary.id?'修改':'添加'}信息</a>
			</li>
		</ul>
		<div class="container saveform">
			<form:form action="${basePath }dict/save" modelAttribute="dictionary" class="form-horizontal">
				<form:hidden path="id"/>
				<form:hidden path="value"/>
				<div class="form-group row">
					<label class="control-label col-2">类型</label>
					<div class="col-8">
						<form:input path="type" class="form-control" placeholder="类型" maxlength="20" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">标签</label>
					<div class="col-8">
						<form:input path="label" class="form-control" placeholder="标签" maxlength="20" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">类型</label>
					<div class="col-8">
						<form:input path="description" class="form-control" placeholder="说明" maxlength="20" />
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
</html>