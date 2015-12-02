<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="container fileupload ng">
	<div class="row">
        <div class="row">
			<div style="float:right;">
				<div class="btn btn-primary glyphicon glyphicon-folder-open file">
					Select File
					<input type="file" nv-file-select uploader="uploader" multiple="multiple" />
				</div> 
				<button type="button" class="btn btn-success btn-s" ng-click="uploader.uploadAll()"
					ng-disabled="!uploader.getNotUploadedItems().length">
					<span class="glyphicon glyphicon-upload"></span> 全部上传
				</button>
				<button type="button" class="btn btn-warning btn-s" ng-click="uploader.cancelAll()"
					ng-disabled="!uploader.isUploading">
					<span class="glyphicon glyphicon-ban-circle"></span> 全部取消
				</button>
				<button type="button" class="btn btn-danger btn-s" ng-click="uploader.clearQueue()"
					ng-disabled="!uploader.queue.length">
					<span class="glyphicon glyphicon-trash"></span> 全部移除
				</button>
			</div>
			<div style="clear:both;">
				上传进度:
				<div class="progress">
					<div class="progress-bar" role="progressbar" ng-style="{ 'width': uploader.progress + '%' }"></div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<input type="hidden" value="${requestScope.tourism.id }" id="tourismid">
			<h3>文件上传列表</h3>
			<p>文件数量: <span ng-bind="uploader.queue.length"></span></p>
			<table class="table table-striped">
				<tr style="text-align: left;">
					<th width="50%">文件名称</th>
					<th ng-show="uploader.isHTML5">大小</th>
					<th ng-show="uploader.isHTML5">进度</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<tr ng-repeat="item in uploader.queue">
					<td><strong ng-bind="item.file.name"></strong></td>
					<td ng-show="uploader.isHTML5" nowrap ng-bind-template="{{item.file.size/1024/1024|number:2}} MB"></td>
					<td ng-show="uploader.isHTML5">
						<div class="progress" style="margin-bottom: 0;">
							<div class="progress-bar" role="progressbar" ng-style="{ 'width': item.progress + '%' }"></div>
						</div>
					</td>
					<td class="text-center"><span ng-show="item.isSuccess"> <i
							class="glyphicon glyphicon-ok"></i>
					</span> <span ng-show="item.isCancel"> <i class="glyphicon glyphicon-ban-circle"></i>
					</span> <span ng-show="item.isError"> <i class="glyphicon glyphicon-remove"></i>
					</span></td>
					<td nowrap>
						<button type="button" class="btn btn-success btn-xs" ng-click="item.upload()"
							ng-disabled="item.isReady || item.isUploading || item.isSuccess">
							<span class="glyphicon glyphicon-upload"></span> 上传
						</button>
						<button type="button" class="btn btn-warning btn-xs" ng-click="item.cancel()"
							ng-disabled="!item.isUploading">
							<span class="glyphicon glyphicon-ban-circle"></span> 取消
						</button>
						<button type="button" class="btn btn-danger btn-xs" ng-click="item.remove()">
							<span class="glyphicon glyphicon-trash"></span> 移除
						</button>
					</td>
				</tr>
			</table>
		</div>

	</div>
</div>