require.config({
	paths : bk.getPaths(),
	// 这个配置是你在引入依赖的时候的包名
	shim : bk.shim
//	,
//	// 禁止缓存
//	"urlArgs" : "bust=" + (new Date()).getTime()
});

require.config({
	paths : {
		// app
		"app" : [ bk.getJsPath() + "modules/tourism/tourism/img_info/app" ],
		"angularFileUpload" : [ bk.getJsPath() + "common/angularjs/angular-file-upload.min" ],
		// controller
		"AppController" : [ bk.getJsPath() + "modules/tourism/tourism/img_info/controller/TourismImgController" ],
		// common-service
		"CrudService" : [ bk.getJsPath() + "modules/common/CrudService" ],
		"jBox" : [ bk.getJsPath() + "common/jBox/jBox.min" ]
	},
	shim : {
		'angularFileUpload' : {
			deps : [ "angular" ],
			exports : 'angularFileUpload'
		},
		'jBox' : {
			deps : [ "jquery" ],
			exports : 'jBox'
		}
	}
});

require([ "jquery", 'angular', 'ui-router', "app", "AppController" ], function($, angular) {
	$(function() {
		// 启动angularjs
		angular.bootstrap(document, [ "app" ]);
		$(".ng").show();
	});

})