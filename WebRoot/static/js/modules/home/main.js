require.config({
	paths : {
		"jquery" : [ bk.getJsPath() + "common/jquery_1.7.2" ]
	},
	// 禁止缓存
	"urlArgs" : "bust=" + (new Date()).getTime()
});

require.config({
	paths : {
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
		},
		'index' : {
			deps : [ "jquery", "treemenu", "jerichotab" ],
			exports : 'index'
		}
	}
});

require([ "index" ], function($, angular) {

})