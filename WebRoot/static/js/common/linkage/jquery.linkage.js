/**
 * 基于select2的联动效果
 * 
 * @param window
 * @param $
 */
(function(window, $) {
	var w = window;
	"use strict";
	var defaults = {
		url : "linkage-url",// 访问后台的请求路径
		initSelect : true,// 是否在加载的时候初始化
		num : "linkage-num",// 顺序号例如：1-1，1-2，2-1，2-2
		label : "linkage-label",// 显示值
		value : "linkage-value"// 实际值
	};
	$.fn.linkage = function(settings) {

		if (this.length === 0) {
			return;
		}

		defaults = $.extend(defaults, settings);

		init(this);

		bindChange(this);

	}

	function init(obj) {

		if (!defaults.initSelect) {
			return;
		}

		$(obj).each(function() {
			if (this.localName == "select") {
				var $this = $(this);
				var num = $this.attr(defaults.num);
				if (num.charAt(2) == "1") {
					createSelect($this, null);
				}
			}
		});

	}

	function bindChange(obj) {

		$(obj).each(function() {
			if (this.localName == "select") {
				var $this = $(this);
				$this.bind("change", function() {
					var num = $this.attr(defaults.num);
					var n = parseInt(num.charAt(2)) + 1;
					var nextNum = num.charAt(0) + num.charAt(1) + n;
					$.each(obj, function() {
						var $nextThis = $(this);
						if ($nextThis.attr(defaults.num) == nextNum) {
							var data = {};
							data.id = $this.val();
							createSelect($nextThis, data);
						}
					})
				});
			}
		});

	}

	/**
	 * 通过键属性名称，找到JSON对象中的值（key可以嵌套对象）
	 */
	function getValue(key, values) {
		var value;
		var sub_keys = key.split(".");
		var length = sub_keys.length;
		if (length > 1) {// 属性嵌套
			var sub_n = values;
			for (var i = 0; i < length; i++) {
				sub_n = sub_n[sub_keys[i]];
				if (sub_n == null) {
					return '';
				}
			}
			return sub_n;
		} else {
			return values[key];
		}
		return null;
	}

	/**
	 * 创建下拉框内容
	 */
	function createSelect(obj, data) {
		$.post(obj.attr(defaults.url), data).success(
				function(data) {
					console.log(data);
					if (data == null) {
						return;
					}
					var options = '<option value=""></option>';
					$.each(data, function() {
						options += '<option value="' + getValue(obj.attr(defaults.value), this) + '">'
								+ getValue(obj.attr(defaults.label), this) + '</opiton>';
					})
					obj.empty();
					obj.append(options);
				});
	}

})(window, jQuery)