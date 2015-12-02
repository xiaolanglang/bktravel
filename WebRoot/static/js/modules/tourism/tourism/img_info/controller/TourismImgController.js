define([ "app", "jquery", "angularFileUpload", "CrudService" ], function(app, $) {
	return app.controller("AppController", [ "$scope", "FileUploader", "CrudService",
			function($scope, FileUploader, crudService) {

				var saveFileUrl = bk.getBasePath() + "tourismImg/save";
				var fileListUrl = bk.getBasePath() + "tourismImg/list";
				$scope.formData = {};

				var uploader = $scope.uploader = new FileUploader({
					url : saveFileUrl,
					formData : [ $scope.formData ]
				});

				// FILTERS

				uploader.filters.push({
					name : 'customFilter',
					fn : function(item /* {File|FileLikeObject} */, options) {
						console.info("filter>>>>>>>>>item:", item);
						console.info("filter>>>>>>>>>options:", options);
						return this.queue.length < 10;
					}
				});

				// CALLBACKS

				uploader.onWhenAddingFileFailed = function(item /* {File|FileLikeObject} */, filter, options) {
					console.info('onWhenAddingFileFailed', item, filter, options);
				};
				uploader.onAfterAddingFile = function(fileItem) {
					console.info('onAfterAddingFile', fileItem);
				};
				uploader.onAfterAddingAll = function(addedFileItems) {
					console.info('onAfterAddingAll', addedFileItems);
				};
				uploader.onBeforeUploadItem = function(item) {
					console.info('onBeforeUploadItem', item);
				};
				uploader.onProgressItem = function(fileItem, progress) {
					console.info('onProgressItem', fileItem, progress);
				};
				uploader.onProgressAll = function(progress) {
					console.info('onProgressAll', progress);
				};
				uploader.onSuccessItem = function(fileItem, response, status, headers) {
					console.info('onSuccessItem', fileItem, response, status, headers);
				};
				uploader.onErrorItem = function(fileItem, response, status, headers) {
					console.info('onErrorItem', fileItem, response, status, headers);
				};
				uploader.onCancelItem = function(fileItem, response, status, headers) {
					console.info('onCancelItem', fileItem, response, status, headers);
				};
				uploader.onCompleteItem = function(fileItem, response, status, headers) {
					console.info('onCompleteItem', fileItem, response, status, headers);
				};
				uploader.onCompleteAll = function() {
					crudService.findAllList($scope, $scope.formData, fileListUrl).success(function(data) {
						$scope.imgList = data;
					});
				};

				$scope.formData.id = $("#tourismid").val();
				console.info('uploader', uploader);
				crudService.findAllList($scope, $scope.formData, fileListUrl).success(function(data) {
					$scope.imgList = data;
				});

			} ]);
});