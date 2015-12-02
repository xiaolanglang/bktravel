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
			<li><a href="<%=basePath%>attraction/list">景点列表</a></li>
			<li class="active"><a>${not empty attraction.id?'修改':'添加'}信息</a></li>
		</ul>
		<div class="container saveform">
			<form:form action="${basePath }attraction/save" modelAttribute="attraction"
				class="form-horizontal">
				<form:hidden path="id" />
				<div class="form-group row">
					<label class="control-label col-2">区域名称</label>
					<div class="col-8">
						<select class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-1"
							linkage-url="${basePath }position/continentSelections">
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">国家名称</label>
					<div class="col-8">
						<select class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-2"
							linkage-url="${basePath }position/nationSelections">
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">省会名称</label>
					<div class="col-8">
						<select class="select2 linkage" linkage-label="name" linkage-value="id" linkage-num="1-3"
							linkage-url="${basePath }position/provinceSelections">
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">城市名称</label>
					<div class="col-8">
						<form:select path="city.id" class="select2 linkage" linkage-label="name" linkage-value="id"
							linkage-num="1-4" linkage-url="${basePath }position/citySelections">
						</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">景点名称</label>
					<div class="col-8">
						<form:input path="name" class="form-control" placeholder="景区名称" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">标题</label>
					<div class="col-8">
						<form:input path="title" class="form-control" placeholder="标题名称" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">是否隐藏</label>
					<div class="radio-inline col-8">
						<label>
							<form:radiobutton path="hide" value="0"/>是</label>
						&nbsp;&nbsp;
						<label>
							<form:radiobutton path="hide" value="1"/>否</label>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">适合人群</label>
					<div class="col-8">
						<form:input path="forPeople" class="form-control" placeholder="适合人群" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">景点类型</label>
					<div class="col-8">
						<form:input path="type" class="form-control" placeholder="景点类型" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">景区地址</label>
					<div class="col-8">
						<form:input path="place" class="form-control" placeholder="景区地址" />
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
</html>