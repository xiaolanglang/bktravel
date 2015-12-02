<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<title>线路操作</title>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>common/jquery.slides.css">
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/common/content-right-save.css">
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>common/stepBar.css">
	<script type="text/javascript" src="<%=jsPath%>common/jquery.stepBar.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#stepBar").stepBarInit({step:4});
		});
	</script>
</head>
<body>
	<div class="contents">
		<ul class="nav-tabs nav">
			<li>
				<a href="<%=basePath%>tourism/list">线路列表</a>
			</li>
			<li class="active">
				<a>${not empty tourismDetail.id?'修改':'添加'}信息</a>
			</li>
		</ul>
		<%@include file="/WEB-INF/views/modules/tourism/tourism/include/stepBar.jsp" %>
		<div class="content-title title-1">
			<div class="content-column col-8">
				<ul class="nav navbar-nav col-10" id="tourism-route">
					<li>
						<a href="javascript:void(0)" class="selected slide-day" slide-day="1">第1天</a>
					</li>
					<li>
						<a id="column-add" href="javascript:void(0)" class="glyphicon glyphicon-plus">增加行程</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="container saveform">
			<div id="slides">
				<div>
					<form:form action="${basePath }tourismDetail/save" modelAttribute="tourismDetail" class="form-horizontal">
						<form:hidden path="tourism.id"/>
						<div class="form-group row">
							<label class="control-label col-2">行程路线</label>
							<div class="col-8">
								<form:input path="id" class="form-control" placeholder="行程路线" maxlength="15" />
							</div>
						</div>
						<div class="form-group row">
							<div class="radio col-8 col-push-2">
								<input type="submit" class="btn btn-primary" value="下一步">
							</div>
						</div>
					</form:form>
				</div>
				<div>
					<form:form action="${basePath }tourismDetail/save" modelAttribute="tourismDetail" class="form-horizontal">
						<form:hidden path="tourism.id"/>
						<div class="form-group row">
							<label class="control-label col-2">行程路线</label>
							<div class="col-8">
								<form:input path="id" class="form-control" placeholder="行程路线" maxlength="15" />
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
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=jsPath%>common/requirejs_2.1.11.js" 
		data-main="<%=jsPath %>modules/tourism/tourism/img_route/main.js"></script>
</html>