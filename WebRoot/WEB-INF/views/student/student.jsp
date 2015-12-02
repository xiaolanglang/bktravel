<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="path" value="${pageContext.request.contextPath}/admin"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP title</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  ........................................................
  	<form:form modelAttribute="student" method="post" action="${path }/home/save2">
  		<form:input path="name"/>
  		<form:select path="school">
  			<form:option value=""></form:option>
  			<form:option value="学校一">学校一</form:option>
  			<form:option value="学校二">学校二</form:option>
  			<form:option value="学校三">学校三</form:option>
  		</form:select>
  		女<form:radiobutton path="sex" value="女"/>
  		男<form:radiobutton path="sex" value="男"/>
  		否<form:radiobutton path="sex" value="否"/>
  		<br>
  		<form:checkbox path="hobby" value="羽毛球"/>羽毛球
  		<form:checkbox path="hobby" value="网球"/>网球
  		<form:checkbox path="hobby" value="篮球"/>篮球
  		<form:checkbox path="hobby" value="其他"/>其他
  		<input type="submit" value="提交">
  	</form:form>
  </body>
</html>
