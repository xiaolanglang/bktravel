define([ "jquery", "treemenu", "jerichotab" ], function($) {
	$(function() {
		// 用户信息下拉框部分
		var user_msg_dropmenu;
		$("#user-msg").hover(function() {
			clearTimeout(user_msg_dropmenu);
			$("#user-msg>.img").css("background-image", 'url("' + bk.getImgPath() + 'portlet-expand-icon.png")');
			$("#user-msg").css("background-color", '#414D5C');
			$("#user-msg-dropmenu").show();
		}, function() {
			clearTimeout(user_msg_dropmenu);
			user_msg_dropmenu = setTimeout(function() {
				$("#user-msg>.img").css("background-image", 'url("' + bk.getImgPath() + 'portlet-collapse-icon.png")');
				$("#user-msg").css("background-color", '');
				$("#user-msg-dropmenu").hide();
			}, 500);
		});

		$("#user-msg-dropmenu").hover(function() {
			clearTimeout(user_msg_dropmenu);
		}, function() {
			clearTimeout(user_msg_dropmenu);
			user_msg_dropmenu = setTimeout(function() {
				$("#user-msg>.img").css("background-image", 'url("' + bk.getImgPath() + 'portlet-collapse-icon.png")');
				$("#user-msg").css("background-color", '');
				$("#user-msg-dropmenu").hide();
			}, 500);
		});
	});

	$(function() {
		$("#content-left-menu").bkCreateTree(); // 创建树的特效

		var jericho = {
			init : function() {
				$('a[class^=func]').click(function() {
					$.fn.jerichoTab.addTab({
						tabFirer : $(this),
						title : $(this).find("span[class^=msg]").text(),
						closeable : true,
						iconImg : $(this).attr('iconImg'),
						data : {
							dataType : $(this).attr('dataType'),
							dataLink : $(this).attr('dataLink')
						}
					}).showLoader().loadData();
				});

				$.fn.initJerichoTab({
					renderTo : '#content-right',
					uniqueId : 'myJerichoTab',
					contentCss : {
						'height' : '674px'// 标签下面的内容的高度
					}
				// ,
				// tabs: [{
				// title: 'JeirchoTab',
				// closeable: true,
				// data: {
				// dataType: 'formtag',
				// dataLink: '#tbNews'
				// }
				// }]
				});
			}
		}
		jericho.init();
	});
})
