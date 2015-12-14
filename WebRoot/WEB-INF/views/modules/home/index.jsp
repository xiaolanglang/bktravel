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
	<div class="head" id="header">
		<div class="head-left">
			<div class="log">
				<img src="<%=imgPath%>logo.png"></div>
			<h4 class="log-msg"> <strong>门户后台管理</strong>
			</h4>
		</div>
		<div class="head-right">
			<div class="user-img">
				<!-- <img src="../../img/logo.png" alt="" class="round"> -->
				<span class="glyphicon glyphicon-user round"></span>
			</div>
			<div class="user-msg">
				<span id="user-msg">
					系统管理员
				</span>
				<div class="user-msg-menu" id="user-msg-dropmenu">
					<ul class="dropdown-menu" >
						<li>
							<a href="<%=bpath %>loginout">退出</a>
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
			<div id="openClose">
				<div class="openClose">
					<div></div>
					<div></div>
					<div></div>
				</div>
			</div>
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
							dataLink='<%=basePath %>startPlace/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">出发地</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe'
							dataLink='<%=basePath %>tourismType/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">旅游线路类型</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe'
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
						<span class="msg">前台用户管理</span>
						<span class="icon-circle-up font-ico"></span>
					</a>
					<ul>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>dict/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">用户管理</span>
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
							dataLink='<%=basePath %>continent/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">地域</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe'
							dataLink='<%=basePath %>nation/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">国家</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>province/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">省会</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>city/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">城市</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>country/list'>
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
							dataLink='<%=basePath %>dict/list'>
								<span class="icon-menu font-ico"></span>
								<span class="msg">字典管理</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>account/list'>
								<span class="icon-cloud font-ico"></span>
								<span class="msg">账户管理</span>
								<span class="font-ico"></span>
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" class="menu-father">
								<span class="icon-menu font-ico"></span>
								<span class="msg">授权管理</span>
								<span class="icon-circle-up font-ico"></span>
							</a>
							<ul class="nav">
								<li>
									<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>permissions/list'>
										<span class="icon-cloud font-ico"></span>
										<span class="msg">权限管理</span>
										<span class="font-ico"></span>
									</a>
								</li>
								<li>
									<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>role/list'>
										<span class="icon-cloud font-ico"></span>
										<span class="msg">角色管理</span>
										<span class="font-ico"></span>
									</a>
								</li>
								<li>
									<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>rolepermission/list'>
										<span class="icon-cloud font-ico"></span>
										<span class="msg">角色权限管理</span>
										<span class="font-ico"></span>
									</a>
								</li>
								<li>
									<a href="javascript:void(0)" class="func" dataType='iframe' 
							dataLink='<%=basePath %>accountrole/list'>
										<span class="icon-cloud font-ico"></span>
										<span class="msg">账户角色管理</span>
										<span class="font-ico"></span>
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="content-right" class="content-right">
			<iframe id="mainFrame" name="mainFrame" src="" style="overflow:visible;" scrolling="yes" frameborder="no" width="100%" height="650"></iframe>
		</div>
	</div>
	<div class="footer" id="footer">
		Created By gitHub-XiaoLangLang @2015-1-1
	</div>
</body>
	<%@include file="/WEB-INF/views/include/js.jsp"%>
	<script type="text/javascript" src="<%=jsPath%>modules/common/bk.js"></script>
	<script type="text/javascript" src="<%=jsPath%>common/requirejs/requirejs_2.1.11.js"
	data-main="<%=jsPath%>modules/home/main.js"></script>
</html>