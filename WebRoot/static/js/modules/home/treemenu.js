(function($) {

	var checkMove = function(obj) {
		if (!obj.next().is("ul")) {
			return true;
		}
		if (obj.hasClass("move-on")) {
			return true;
		} else {
			return false;
		}
	}

	var createTree = function() {
		$(this).on("click", "a[class^=menu-father]", function() {
			$(this).next().stop(true);
			if ($(this).hasClass("menu-open")) { //关闭
				//改变图标
				$(this).removeClass("menu-open");
				$(this).find("span:last-child").removeClass("icon-circle-down").addClass("icon-circle-up");
				//下拉效果
				$(this).next().slideToggle("fast");

			} else { //打开
				// 关闭上一个
				if ($(this).parent().parent().attr("id") === "content-left-menu") {
					$("#content-left-menu > li > a.menu-open").click();
				}
				$(this).addClass("menu-open");
				$(this).find("span:last-child").removeClass("icon-circle-up").addClass("icon-circle-down");
				$(this).next().slideToggle("fast");
			}
		})

		$(this).on("click", "a[class^=func]", function(event) {
			var style = {
				"background-color": "#0099CC",
				"color": "#FFF1F8"
			};
			var nostyle = {
				"background-color": "",
				"color": ""
			};
			$(event.delegateTarget).find("a[class^=func]").css(nostyle);
			$(this).css(style);
		})

		return this;
	}

	$.fn.extend({
		bkCreateTree: createTree
	});

})(jQuery)