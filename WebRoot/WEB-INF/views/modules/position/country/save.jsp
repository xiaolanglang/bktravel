<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>县操作</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-save.css"></head>
<body>
	<div class="contents">
		<ul class="nav-tabs nav">
			<li>
				<a href="<%=basePath%>country/list">县列表</a>
			</li>
			<li class="active">
				<a>${not empty country.id?'修改':'添加'}信息</a>
			</li>
		</ul>
		<div class="container saveform">
			<form:form action="${basePath }country/save" modelAttribute="country" class="form-horizontal">
				<form:hidden path="id"/>
				<div class="form-group row">
					<label class="control-label col-2">区域名称</label>
					<div class="col-8">
						<select class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-1" linkage-url="${basePath }position/continentSelections">
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">国家名称</label>
					<div class="col-8">
						<select class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-2" linkage-url="${basePath }position/nationSelections">
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">省会名称</label>
					<div class="col-8">
						<select class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-3" linkage-url="${basePath }position/provinceSelections">
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">城市名称</label>
					<div class="col-8">
						<form:select path="city.id" class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-4" linkage-url="${basePath }position/citySelections">
						</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">县名称</label>
					<div class="col-8">
						<form:input path="name" class="form-control" placeholder="输入县名称" maxlength="15" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">英文名称</label>
					<div class="col-8">
						<form:input path="nameEn" class="form-control" placeholder="输入英文名称" maxlength="20" />
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