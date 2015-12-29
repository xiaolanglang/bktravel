<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="container" style="padding-bottom:30px;">
	<div class="img-box scroll">
	
		<div class="ng">
			<div class="item" ng-repeat="img in imgList">
				<div class="{{img.cover == '1'?'file-iscover':'hide'}}">封面</div>
				<div class="file-icon" style="background-image: url({{img.url}});">
				</div>
				<div class="file-name">
					<a node-type="name" href="javascript:void(0);" ng-bind="img.name"></a>
				</div>
				<div class="file-del round">
				</div>
				<a href="javascript:void(0)" class="glyphicon glyphicon-trash file-del-img round" ng-click="del(img.id)"></a>
				<!-- <a href="javascript:void(0)" class="file-cover" ng-click="cover(img.id)">
					设为封面(暂时隐藏)
				</a> -->
			</div>
		</div>
		
	</div>
</div>