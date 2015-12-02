<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="container" style="padding-bottom:30px;">
	<div class="img-box scroll">
	
		<div class="ng">
			<div class="item" ng-repeat="img in imgList">
				<div class="file-icon" style="background-image: url(<%=filePath %>{{img.url}});">
				</div>
				<div class="file-name">
					<a node-type="name" href="javascript:void(0);" ng-bind="img.name"></a>
					<!-- 文件名称编辑 -->
					<!-- <div node-type="edit-name" class="edit-name">
						<input node-type="edit-name-box" class="box" type="text" value=""> <span
							node-type="edit-name-sure" class="sure"></span> <span node-type="edit-name-cancel"
							class="cancel"></span>
					</div> -->
				</div>
			</div>
		</div>
		
	</div>
</div>