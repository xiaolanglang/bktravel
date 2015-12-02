define(["app", "jquery", "crudService"], function(userApp, $) {
	return userApp.controller('userCtrl', ['$scope', '$http', 'crudService', function($scope, $http, crudService) {
		$scope.users = {};
		var url = '../../data/backstage/module/user/userList.json';
		crudService.getList($scope, null, url, 1).success(function(data) {
			$scope.users = data;
		});
	}]);
});