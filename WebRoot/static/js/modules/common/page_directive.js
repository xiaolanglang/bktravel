app.directive('paging', function($timeout) {
	return {
		template : '<div id="pageDiv" style="display:none;{{page.show}}">'
				+ '第<strong class="blue">{{page.pageNum}}</strong>页/共<strong class="blue">{{page.pages}}'
				+ '</strong>页&nbsp;&nbsp;' + '<a id="page_index" href="" style="margin-right:3px;'
				+ '{{1==page.pageNum?\'cursor:default;color:#CCCCCC;\':1}}">首</a>'
				+ '<span class="prev-gray" style="{{page.style1}}"}></span>'
				+ '<a id="page_pre" class="prev-btn" href="" style="{{page.style2}}"></a>'
				+ '<a id="{{pageNo}}" ng-repeat="pageNo in page.pageNos" class="{{pageNo==page.pageNum?\'on\':1}}"'
				+ 'href="" ng-click="query(pageNo)" style="margin-left:2px">{{pageNo}}</a>'
				+ '<span class="next-gray" style="{{page.style3}}"></span>'
				+ '<a id="page_next" class="next-btn" href="" style="{{page.style4}}"></a>'
				+ '<a id="page_last" href="" style="margin-left:3px;'
				+ '{{page.pages==page.pageNum?\'cursor:default;color:#CCCCCC;\':1}}">末</a>'
				+ '<em>&nbsp;跳转到第&nbsp;</em>' + '<input id="gotoPage" ng-model="gotoPage" type="text">'
				+ '<em>&nbsp;&nbsp;页&nbsp;&nbsp;</em>' + '<a id="page_skip" class="confirm" href="">确定</a>' + '</div>',
		replace : true,
		'restrict' : 'AE',
		scope : {
			page : '=pageObject',
			query : '=clickFunction'

		},
		link : function($scope, $element) {
			$scope.bindEvent = function() {
				$element.find('a').on('click', function() {
					if ($(this).attr("id") == "page_index") {
						if ($scope.page.pageNum == 1) {
							return;
						}
						$scope.page.pageNum = 1;
					} else if ($(this).attr("id") == "page_pre") {
						$scope.page.pageNum = $scope.page.pageNum - 1;
						if ($scope.page.pageNum <= 0) {
							$scope.page.pageNum = 1;
						}
					} else if ($(this).attr("id") == "page_next") {
						$scope.page.pageNum = $scope.page.pageNum + 1;
						if ($scope.page.pageNum > $scope.page.pages) {
							$scope.page.pageNum = $scope.page.pages;
						}
					} else if ($(this).attr("id") == "page_last") {
						$scope.page.pageNum = $scope.page.pages;
					} else if ($(this).attr("id") == "page_skip") {
						if (parseInt($("#gotoPage").val()) > $scope.page.pages) {
							$scope.page.pageNum = $scope.page.pages;
						} else if (parseInt($("#gotoPage").val()) > 0) {
							$scope.page.pageNum = parseInt($("#gotoPage").val());
						} else {
							$scope.page.pageNum = 1;
						}
					} else {
						$scope.page.pageNum = 1;
					}
					$scope.query($scope.page.pageNum);
				});
			}
			// 调用
			$scope.bindEvent();
		}
	}
});

function getPageNos(scope, pageNum, pages) {
	if (pages == 0) {
		scope.pageing.show = '';
		return;
	}
	var num = 5;// 要显示的按钮(页数)个数

	scope.pageing = {
		gotoPage : 0,
		pages : 0,
		pageNos : [],
		style1 : 'display:none',
		style2 : 'display:none',
		style3 : 'display:none',
		style4 : 'display:none',
		show : 'display:inline'
	};
	scope.pageing.pageNum = pageNum;
	scope.pageing.pages = pages;

	if (pageNum > 1 && pageNum == pages) {
		scope.pageing.style2 = '';
		scope.pageing.style3 = '';
	} else if (pageNum == 1 && pageNum < pages) {
		scope.pageing.style1 = '';
		scope.pageing.style4 = '';
	} else if (pageNum > 1 && pageNum < pages) {
		scope.pageing.style2 = '';
		scope.pageing.style4 = '';
	} else if (pageNum == 1 && 1 == pages) {
		scope.pageing.style1 = '';
		scope.pageing.style3 = '';
	}

	var pageNos = new Array();

	if (pages <= 5) {
		pageNum = 1;
		for (var i = 0; i < num; i++) {
			pageNos[i] = pageNum;
			pageNum++;
			if (pageNum > pages) {
				break;
			}
		}
	} else if (pageNum >= 3 && pageNum + 2 <= pages) {
		pageNum = pageNum - 2;
		for (var i = 0; i < num; i++) {
			pageNos[i] = pageNum;
			pageNum++;
			if (pageNum > pages) {
				break;
			}
		}
	} else if (pageNum < 3 && pageNum + 2 <= pages) {
		pageNum = 1;
		for (var i = 0; i < num; i++) {
			pageNos[i] = pageNum;
			pageNum++;
			if (pageNum > pages) {
				break;
			}
		}
	} else if (pageNum >= 3 && pageNum + 2 > pages) {
		pageNum = pages - 4;
		for (var i = 0; i < num; i++) {
			pageNos[i] = pageNum;
			pageNum++;
			if (pageNum > pages) {
				break;
			}
		}
	}
	scope.pageing.pageNos = pageNos;
}