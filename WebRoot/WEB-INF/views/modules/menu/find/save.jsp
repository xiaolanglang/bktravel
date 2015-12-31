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
			<li><a href="<%=basePath%>menu/find/list">景点列表</a></li>
			<li class="active"><a>${not empty menuFind.id?'修改':'添加'}信息</a></li>
		</ul>
		<div class="container saveform">
			<form:form action="${basePath }menu/find/save" modelAttribute="menuFind"
				class="form-horizontal">
				<form:hidden path="id" />
				<div class="form-group row">
					<label class="control-label col-2">标题</label>
					<div class="col-8">
						<form:input path="title" class="form-control required" placeholder="标题" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">副标题</label>
					<div class="col-8">
						<form:input path="subTitle" class="form-control required" placeholder="副标题" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">搜索关键词</label>
					<div class="col-8">
						<form:input path="keyword" class="form-control required" placeholder="搜索关键词" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">图片</label>
					<div class="col-8">
						<form:input path="image" class="form-control required" placeholder="位置" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">是否隐藏</label>
					<div class="radio-inline col-8">
						<label>
							<form:radiobutton path="hide" value="1" class=" required"/>是</label>
						&nbsp;&nbsp;
						<label>
							<form:radiobutton path="hide" value="0" class=" required"/>否</label>
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