define([ "app", "jquery", "angularFileUpload", "CrudService" ], function(app, $) {
	return app.controller("AppController", [ "$scope", "FileUploader", "CrudService",
			function($scope, FileUploader, crudService) {

				var saveFileUrl = bk.getBasePath() + "tourismImg/save";
				var fileListUrl = bk.getBasePath() + "tourismImg/list";
				var delFileUrl = bk.getBasePath() + "tourismImg/del";
				var coverFileUrl = bk.getBasePath() + "tourismImg/cover";
				$scope.formData = {};
				$scope.del = function(id) {
					crudService.del({"id":id},delFileUrl).success(function(){
						updateView();
					});
				}
				
				$scope.cover = function(id) {
					crudService.del({"id":id},coverFileUrl).success(function(){
						updateView();
					});
				}
				function updateView() {
					crudService.findAllList($scope, $scope.formData, fileListUrl).success(function(data) {
						$scope.imgList = data;
					});
				}

				var uploader = $scope.uploader = new FileUploader({
					url : saveFileUrl,
					formData : [ $scope.formData ]
				});

				// FILTERS

				uploader.filters.push({
					name : 'customFilter',
					fn : function(item /* {File|FileLikeObject} */, options) {
						return this.queue.length < 10;
					}
				});

				// CALLBACKS

				uploader.onWhenAddingFileFailed = function(item /* {File|FileLikeObject} */, filter, options) {
				};
				uploader.onAfterAddingFile = function(fileItem) {
				};
				uploader.onAfterAddingAll = function(addedFileItems) {
				};
				uploader.onBeforeUploadItem = function(item) {
				};
				uploader.onProgressItem = function(fileItem, progress) {
				};
				uploader.onProgressAll = function(progress) {
				};
				uploader.onSuccessItem = function(fileItem, response, status, headers) {
				};
				uploader.onErrorItem = function(fileItem, response, status, headers) {
				};
				uploader.onCancelItem = function(fileItem, response, status, headers) {
				};
				uploader.onCompleteItem = function(fileItem, response, status, headers) {
				};
				uploader.onCompleteAll = function() {
					updateView();
				};

				$scope.formData.id = $("#tourismid").val();
				updateView();

			} ]);
});