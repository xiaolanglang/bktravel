//调整页面整体框架显示部分
(function() {
	var tabTitleHeight = 33;
	// 页签的高度
	var htmlObj = $("html");
	var headerObj = $("#header"),
		footerObj = $("#footer");
	var frameObj = $("#content-right, #content-right iframe");
	function wSize() {
		var minHeight = 500,
			minWidth = 980;
		var strs = getWindowSize().toString().split(",");

		htmlObj.css({
			"overflow-x": strs[1] < minWidth ? "auto" : "hidden",
			"overflow-y": strs[0] < minHeight ? "auto" : "hidden"
		});
		frameObj.height((strs[0] < minHeight ? minHeight : strs[0]) - headerObj.height() - footerObj.height() );
		$(".jericho_tab iframe").height($("#content-right").height() - tabTitleHeight);
	}
	var getWindowSize = function() {
		return ["Height", "Width"].map(function(name) {
			return window["inner" + name] ||
				document.compatMode === "CSS1Compat" && document.documentElement["client" + name] || document.body["client" + name];
		});
	};

	$(window).resize(function() {
		wSize();
	});
	wSize();

	$(function() {
		$("#openClose").click(function() {
			if ($("#openClose").hasClass("close")) {//打开
				$(".content-left").css("width", "185px");
				$("#openClose").removeClass("close");
				$(".content-right").css("padding-left","185px");
			} else {//关闭
				$("#content-left-menu > li > a.menu-open").click();
				$(".content-left").css("width", "42px");
				$("#openClose").addClass("close");
				$("#content-left-menu").find("ul").hide();
				$(".content-right").css("padding-left","45px");
			}
		});

		$(".content-left").on("click", "li", function() {
			if ($("#openClose").hasClass("close")) {
				$(".content-left").css("width", "185px");
				$("#openClose").removeClass("close");
				$(".content-right").css("padding-left","185px");
			}
		});
	})
})()

//创建菜单树的点击效果以及初始化initJerichoTab的高度
$(function() {
	//创建树的特效
	$("#content-left-menu").bkCreateTree();
	// 页签的高度
	var tabTitleHeight = 33;

	$.fn.initJerichoTab({
		renderTo: '#content-right',
		uniqueId: 'myJerichoTab',
		contentCss: {
			'height': $('#content-right').height() - tabTitleHeight
		}
	});
	$("#mainFrame").hide();

	$('a[class^=func]').click(function() {
		$.fn.jerichoTab.addTab({
			tabFirer: $(this),
			title: $(this).find("span[class^=msg]").text(),
			closeable: true,
			iconImg: $(this).attr('iconImg'),
			data: {
				dataType: $(this).attr('dataType'),
				dataLink: $(this).attr('dataLink')
			}
		}).showLoader().loadData();
	});
});
//创建鼠标移入个人信息的监听事件
$(function() {
	//用户信息下拉框部分
	var user_msg_dropmenu;

	$(".user-msg").hover(function() {//鼠标移入
		clearTimeout(user_msg_dropmenu);
		$("#user-msg-dropmenu").show();
		$("#user-msg").css("color","#fff");
	}, function() {//鼠标移出
		 user_msg_dropmenu=setTimeout(function() {
			$("#user-msg-dropmenu").hide();
			$("#user-msg").css("color","");
		}, 1000);
	});
});