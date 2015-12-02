<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>线路操作</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-save.css">
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>common/stepBar.css">
	<script type="text/javascript" src="<%=jsPath%>common/jquery.stepBar.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#stepBar").stepBarInit();
		})
	</script>
</head>
<body>
	<div class="contents">
		<ul class="nav-tabs nav">
			<li>
				<a href="<%=basePath%>tourism/list">线路列表</a>
			</li>
			<li class="active">
				<a>${not empty tourism.id?'修改':'添加'}信息</a>
			</li>
		</ul>
		<%@include file="/WEB-INF/views/modules/tourism/tourism/include/stepBar.jsp" %>
		<div class="container saveform">
			<form:form action="${basePath }tourism/save_base" modelAttribute="tourism" class="form-horizontal">
				<form:hidden path="id"/>
				<div class="form-group row">
					<label class="control-label col-2">旅游线路标题</label>
					<div class="col-8">
						<form:input path="title" class="form-control" placeholder="旅游线路标题" maxlength="15" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">旅游线路副标题</label>
					<div class="col-8">
						<form:input path="subtitle" class="form-control" placeholder="旅游线路副标题" maxlength="15" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">出发地</label>
					<div class="col-8">
						<form:select path="startPlace" multiple="multiple" class="select2">
							<form:option value=""></form:option>
							<form:options items="${requestScope.startPlaces }" itemLabel="name" itemValue="id"/>
						</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">旅游线路状态</label>
					<div class="col-8">
						<form:select path="status" multiple="multiple" class="select2">
							<form:option value=""></form:option>
							<form:options items="${msg:getDictList('travel_route_status') }" itemLabel="label" itemValue="value"/>
						</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">旅游线路主题</label>
					<div class="col-8">
						<form:select path="theme" multiple="multiple" class="select2">
							<form:option value=""></form:option>
							<form:options items="${msg:getDictList('travel_theme') }" itemLabel="label" itemValue="value"/>
						</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">旅游线路类型</label>
					<div class="col-8">
						<form:select path="type" class="select2">
							<form:option value=""></form:option>
							<form:options items="${msg:getDictList('tourism_types') }" itemLabel="label" itemValue="value"/>
						</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-2">是否隐藏</label>
					<div class="radio-inline col-8">
						<label>
							<form:radiobutton path="hide" value="0"/>显示</label>
						&nbsp;&nbsp;
						<label>
							<form:radiobutton path="hide" value="1"/>隐藏</label>
					</div>
				</div>
				<div class="form-group row">
					<div class="radio col-8 col-push-2">
						<input type="submit" class="btn btn-primary" value="下一步">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>