(function($) {
	var jq = $;

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
		jq(this).on("click", "a[class^=menu-father]", function() {
			if (jq(this).hasClass("menu-open")) { //打开
				//防止重复
				if (checkMove(jq(this))) {
					return;
				}
				//改变图标
				jq(this).find("span:last-child").removeClass("icon-circle-down").addClass("icon-circle-up");
				//下拉效果
				jq(this).removeClass("menu-open").addClass("move-on").next().slideToggle("normal", function() {
					jq(this).prev().removeClass("move-on")
				});

			} else { //关闭
				if (checkMove(jq(this))) {
					return;
				}
				jq(this).find("span:last-child").removeClass("icon-circle-up").addClass("icon-circle-down");
				jq(this).addClass("menu-open move-on").next().slideToggle("normal", function() {
					jq(this).prev().removeClass("move-on")
				});
			}
		})

		jq(this).on("click","a[class^=func]",function(event){
			jq(event.delegateTarget).find("a[class^=func]").css("background-color","");
			jq(this).css("background-color","#0099CC");
		})

		return this;
	}

	jq.fn.extend({
		bkCreateTree: createTree
	});

})(jQuery)