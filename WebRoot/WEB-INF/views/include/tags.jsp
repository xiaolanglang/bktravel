<%@page import="com.bkweb.common.config.Global"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="msg" uri="http://tzj/message"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
	String cssPath = basePath + "/" + "static/css/";
	String jsPath = basePath + "/" + "static/js/";
	String imgPath = basePath + "/" + "static/img/";
	String filePath = basePath + "/";
	basePath = basePath + Global.getPath() + "/";
%>
<c:set var="basePath" value="<%=basePath%>" />