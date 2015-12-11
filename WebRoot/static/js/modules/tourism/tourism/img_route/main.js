require.config({
	paths : bk.getPaths(),
	// 这个配置是你在引入依赖的时候的包名
	shim : bk.shim
// ,
// // 禁止缓存
// "urlArgs" : "bust=" + (new Date()).getTime()
});

require.config({
	paths : {
		"slides" : [ bk.getJsPath() + "common/slides/jquery.slides" ]
	},
	shim : {
		'slides' : {
			deps : [ "jquery" ],
			exports : 'slides'
		}
	}
});

require(
		[ "jquery", "slides" ],
		function($) {
			$(function() {
				initSlide();

				$("#tourism-route").on("click", ".slide-day", function() {
					tourism_route($(this));
				});

				$("#column-add").click(function() {
					column_add($(this));
				});

			});

			function initSlide() {
				$('#slides').slidesjs({
					start : 1,
					play : {
						active : true,
						auto : false,
						swap : false
					},
					effect : {
						slide : {
							speed : 1000
						}
					}
				});
			}

			function tourism_route($this) {
				var index = $this.attr("slide-day");
				index = index - 1;
				$("#tourism-route").find("a").removeClass("selected");
				$this.addClass("selected");
				$("ul.slidesjs-pagination").find("li:eq(" + index + ")").find(
						"a").click();
			}

			function column_add($this) {
				// 添加栏目
				$("#tourism-route").find(".selected").removeClass("selected");
				var $parent = $this.parent();
				var day = $parent.prev().find("a").attr("slide-day");
				day = day / 1 + 1;
				var a = $parent
						.before('<li><a href="javascript:void(0)" class="selected slide-day" slide-day="'
								+ day + '">第' + day + '天</a></li>');

				// 添加表单
				var htmlObj = $(".slidesjs-control").children().last();
				var index = htmlObj.attr("slidesjs-index");
				index = index / 1 + 1;
				var html = htmlObj.prop("outerHTML");
				$(".slidesjs-control").append(html);
				$(".slidesjs-control").children().last().attr("slidesjs-index",
						index);
				
			}

		});