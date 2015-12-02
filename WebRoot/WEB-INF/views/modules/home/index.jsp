<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>ITravel</title>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/home/index.css">
	<link rel="stylesheet" type="text/css" href="<%=cssPath%>modules/home/jquery.jerichotab.css">
</head>
<body>
	<div class="head">
		<div class="head-left">
			<div class="log">
				<img src="<%=imgPath%>logo.png"></div>
			<h4 class="log-msg"> <strong>门户后台管理</strong>
			</h4>
		</div>
		<div class="head-right">
			<div class="user-img">
				<img src="<%=imgPath%>logo.png"></div>
			<div class="user-msg">
				<span id="user-msg">
					系统管理员
					<div class="img"></div>
				</span>
				<div class="user-msg-menu" id="user-msg-dropmenu">
					<ul class="dropdown-menu">
						<li>
							<a>下拉菜单项</a>
						</li>
						<li>
							<a>下拉菜单项</a>
						</li>
						<li>
							<a>下拉菜单项</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="content-left">
			<ul class="nav content-left-menu" id="content-left-menu">
				<li>
					<a href="javascript:void(0)" class="menu-father">
						<span class="icon-list2 font-ico"></span>
						<span class="msg">管理菜单一</span>
						<span class="icon-circle-up font-ico"></span>
					</a>
					<ul class="nav">
						<li>
							<a href="javascript:void(0)" class="menu-father">
								<span class="icon-menu font-ico"></span>
								<span class="msg">二级菜单</span>
								<span class="icon-circle-up font-ico"></span>
							</a>
							<ul class="nav">
								<li>
									<a href="javascript:void(0)" class="func">
										<span class="icon-cloud font-ico"></span>
										<span class="msg">三级菜单</span>
										<span class="font-ico"></span>
									</a>
								</li>
								<li>
									<a href="javascript:void(0)" class="func">
										<span class="icon-cloud font-ico"></span>
										<span class="msg">三级菜单</span>
										<span class="font-ico"></span>
									</a>
								</li>
								<li>
									<a href="javascript:void(0)" class="func">
										<span class="icon-cloud font-ico"></span>
										<span class="msg">三级菜单</span>
										<span class="font-ico"></span>
									</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe' dataLink='./user.html'
							iconImg='../../img/user.gif'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">二级菜单</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe' dataLink='./user2.html'
							iconImg='../../img/user.gif'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">二级菜单</span>
								<span class="font-ico"></span>
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0)" class="menu-father">
						<span class="icon-list2 font-ico"></span>
						<span class="msg">景点管理</span>
						<span class="icon-circle-up font-ico"></span>
					</a>
					<ul>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe'
							iconImg='<%=imgPath%>jerichotab/user.gif'
							dataLink='<%=basePath %>attraction/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">景点</span>
								<span class="font-ico"></span>
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0)" class="menu-father">
						<span class="icon-list2 font-ico"></span>
						<span class="msg">旅游线路管理</span>
						<span class="icon-circle-up font-ico"></span>
					</a>
					<ul>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe'
							iconImg='<%=imgPath%>jerichotab/user.gif'
							dataLink='<%=basePath %>startPlace/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">出发地</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe'
							iconImg='<%=imgPath%>jerichotab/user.gif'
							dataLink='<%=basePath %>tourismType/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">旅游线路类型</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe'
							iconImg='<%=imgPath%>jerichotab/user.gif'
							dataLink='<%=basePath %>tourism/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">旅游线路</span>
								<span class="font-ico"></span>
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0)" class="menu-father">
						<span class="icon-list2 font-ico"></span>
						<span class="msg">管理菜单四</span>
						<span class="icon-circle-up font-ico"></span>
					</a>
					<ul>
						<li>
							<a href="javascript:void(0)" class="func">
								<span class="icon-cloud font-ico"></span>
								<span class="msg">二级菜单</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func">
								<span class="icon-cloud font-ico"></span>
								<span class="msg">二级菜单</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func">
								<span class="icon-cloud font-ico"></span>
								<span class="msg">二级菜单</span>
								<span class="font-ico"></span>
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0)" class="menu-father">
						<span class="icon-list2 font-ico"></span>
						<span class="msg">位置信息管理</span>
						<span class="icon-circle-up font-ico"></span>
					</a>
					<ul>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe'
							iconImg='<%=imgPath%>jerichotab/user.gif'
							dataLink='<%=basePath %>continent/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">地域</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe'
							dataLink='<%=basePath %>nation/list'
							iconImg='<%=imgPath%>jerichotab/user.gif'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">国家</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>province/list'
							iconImg='<%=imgPath%>jerichotab/user.gif'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">省会</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>city/list'
							iconImg='<%=imgPath%>jerichotab/user.gif'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">城市</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>country/list'
							iconImg='<%=imgPath%>jerichotab/user.gif'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">县</span>
								<span class="font-ico"></span>
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0)" class="menu-father">
						<span class="icon-list2 font-ico"></span>
						<span class="msg">系统管理</span>
						<span class="icon-circle-up font-ico"></span>
					</a>
					<ul class="nav">
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>dict/list'
							iconImg='<%=imgPath%>jerichotab/user.gif'>
								<span class="icon-menu font-ico"></span>
								<span class="msg">基础数据管理</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func">
								<span class="icon-cloud font-ico"></span>
								<span class="msg">二级菜单</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func">
								<span class="icon-cloud font-ico"></span>
								<span class="msg">二级菜单</span>
								<span class="font-ico"></span>
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="content-right" id="content-right"></div>
	</div>
	<div class="footer"></div>
</body>
	<script type="text/javascript" src="<%=jsPath%>modules/common/bk.js"></script>
	<script type="text/javascript" src="<%=jsPath%>common/requirejs_2.1.11.js"
	data-main="<%=jsPath%>modules/home/main.js"></script>
</html>