define([ "angular" ], function(angular) {
	var app = angular.module('app', [ "ui.router", "angularFileUpload" ]);
	app.config(function($httpProvider) {
		$httpProvider.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=UTF-8";
		// $httpProvider.defaults.headers.post["X-Requested-With"]="XMLHttpRequest";
		$httpProvider.defaults.transformRequest = function(data) {
			return bk.initParam(data);
		}
	});
	return app;
})