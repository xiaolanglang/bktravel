define([ "app" ], function(app) {
	return app.service('CrudService', function($http) {

		var findAllList = function(scope, data, url) { // 查询
			return $http({
				method : 'POST',
				url : url,
				data : data
			}).success(function(data) {
			}).error(function(data) {
				alert("查询失败!");
			});
		};

		var findList = function(scope, data, url, pageNum) { // 查询
			// scope.pageing.pageNum = pageNum;
			return $http({
				method : 'POST',
				url : url,
				params : {
					pageNum : pageNum
				},
				data : data
			}).success(function(data) {
				// getPageNos(scope, data.pageNum, data.pages);
			}).error(function(data) {
				alert("查询失败!");
			});
		};

		var save = function(data, url) { // 添加
			return $http({
				method : 'POST',
				url : url,
				data : data
			}).error(function(data) {
				alert("保存失败！");
			});
		};

		var update = function(data, url) { // 更新
			return $http({
				method : 'POST',
				url : url,
				data : data
			}).error(function(data) {
				alert("更新失败！");
			});
		};

		var del = function(data, url) { // 删除
			return $http({
				method : 'POST',
				url : url,
				data : data
			}).error(function(data) {
				alert("删除失败！");
			});
		};

		var getSelections = function(url) { // 获得所有下拉框内容
			return $http({
				method : 'get',
				url : url
			}).error(function(data) {
				alert("获取数据失败!");
			});
		};

		return {
			getSelections : function(url) {
				return getSelections(url);
			},
			findAllList : function(scope, data, url) {
				return findAllList(scope, data, url);
			},
			findList : function(scope, data, url, pageNum) {
				return findList(scope, data, url, pageNum);
			},
			save : function(data, url) {
				return save(data, url);
			},
			update : function(data, url) {
				return update(data, url);
			},
			del : function(data, url) {
				return del(data, url);
			}
		};

	});

})