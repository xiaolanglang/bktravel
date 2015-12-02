require.config({
	paths : {
		"jquery" : [ bk.getJsPath() + "common/jquery_1.7.2" ],
		"angular" : [ bk.getJsPath() + "common/angular" ],
		"ui-router" : [ bk.getJsPath() + "common/angular-ui-router" ]
	},
	// 这个配置是你在引入依赖的时候的包名
	shim : {
		"angular" : {
			exports : "angular"
		},
		'ui-router' : {
			deps : [ "angular" ],
			exports : 'ui-router'
		}
	},
	// 禁止缓存
	"urlArgs" : "bust=" + (new Date()).getTime()
});

require.config({
	paths : {
		// app
		"app" : [ bk.getJsPath() + "modules/app" ],
		// controller
		"userCtrl" : [ bk.getJsPath() + "modules/home/controller/UserCtrl" ],
		// common-service
		"crudService" : [ bk.getJsPath() + "modules/CrudService" ],
		"treemenu" : [ bk.getJsPath() + "modules/home/treemenu" ],
		"jerichotab" : [ bk.getJsPath() + "common/jquery.jerichotab" ],
		"index" : [ bk.getJsPath() + "modules/home/index" ]
	},
	shim : {
		"jquery" : {
			exports : "jquery"
		},
		'jerichotab' : {
			deps : [ "jquery" ],
			exports : 'jerichotab'
		},
		'treemenu' : {
			deps : [ "jquery" ],
			exports : 'treemenu'
		}
	}
});

require([ "jquery", 'angular', 'ui-router', "app", "index" ], function($, angular) {
	$(function() {
		// 启动angularjs
		angular.bootstrap(document, [ "app" ]);
	});

})