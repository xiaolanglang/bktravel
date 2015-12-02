<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP title</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
#table001 td {
	border-bottom: black solid 1px;
}

* {
	padding: 0px;
	margin: 0px;
}
</style>
</head>
<br>
<a href="${path }/home/">form标签</a>
<br>
<br>
<hr>
<br>
<a href="${path }/home/save">get方式请求save方法</a>
（会发生405错误）
<br>
<br>
<form action="${path }/home/save" method="post">
	<input type="submit" value="post方式请求save方法">
</form>
<br>
<hr>
<br>
<a href="${path }/home/exception">异常处理机制</a>
<br>
<br>
<hr>
<br>
<form action="${path }/home/validate" method="post">
	<input name="name" placeholder="长度在2到4">
	<input name="sex" placeholder="长度为1">
	<input type="submit" value="后台传值校验">
</form>
<br>
<hr>
<br> 二者请求路径是一样的，但是所带参数不一样，后台配对的时候也会运行不同的方法。这个请求的判断与请求方式无关。
<br>
<br>
<form action="${path }/home/index" method="post">
	<input name="name" value="11" readonly="readonly">
	<input name="sex" value="1" readonly="readonly">
	<input type="submit" value="不带path参数">
</form>
<br>
<form action="${path }/home/index" method="post">
	<input name="name" readonly="readonly" value="11">
	<input name="sex" readonly="readonly" value="1">
	<input name="path">
	<input name="image">
	<input type="submit" value="带path参数,带image">
</form>
<br>
<hr>
<br>
<form action="${path }/home/checkbox">
	数组参数（在后台观看效果）
	<input type="checkbox" value="1" name="id">
	<input type="checkbox" value="2" name="id">
	<input type="checkbox" value="3" name="id">
	<input type="checkbox" value="4" name="id">
	<input type="submit" value="submit">
</form>
<br>
<br>
<hr>
<br> redirectAttribute对象的使用
<br>
<br>
<a href="${path }/home/reda">返回数组</a>
<br>
<br> 参数值：${param.strs }
<br>
<br>
<hr>
<br>
<form action="${path }/home/inputs">
	数组参数（在后台观看效果）
	<input type="text" value="1" name="name">
	<input type="text" value="2" name="name">
	<input type="text" value="3" name="name">
	<input type="text" value="4" name="name">
	<input type="submit" value="submit">
</form>
<br>
<hr>
<br>
<form action="${path }/home/students" method="post">
	一张table表传值到后台<br> <br>
	<table cellpadding="0px" id="table001" border="0px" cellspacing="0px">
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
		</tr>
		<tr>
			<td>张三<input type="hidden" name="students[0].name" value="张三"></td>
			<td>男<input type="hidden" name="students[0].sex" value="男"></td>
			<td>23<input type="hidden" name="students[0].age" value="23"></td>
		</tr>
		<tr>
			<td>李思思<input type="hidden" name="students[1].name" value="李思思"></td>
			<td>女<input type="hidden" name="students[1].sex" value="女"></td>
			<td>20<input type="hidden" name="students[1].age" value="23"></td>
		</tr>
		<tr>
			<td>王二<input type="hidden" name="students[2].name" value="王二"></td>
			<td>男<input type="hidden" name="students[2].sex" value="男"></td>
			<td>22<input type="hidden" name="students[2].age" value="22"></td>
		</tr>
	</table>
	<input type="submit" value="提交">
</form>
<body>
</body>
</html>
