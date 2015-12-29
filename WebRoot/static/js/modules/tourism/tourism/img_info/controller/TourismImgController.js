define([ "app", "jquery", "angularFileUpload", "CrudService", "jBox" ], function(app, $) {
	return app.controller("AppController", [ "$scope", "FileUploader", "CrudService",
			function($scope, FileUploader, crudService) {

				var saveFileUrl = bk.getBasePath() + "tourismImg/save";
				var fileListUrl = bk.getBasePath() + "tourismImg/list";
				var delFileUrl = bk.getBasePath() + "tourismImg/del";
				var coverFileUrl = bk.getBasePath() + "tourismImg/cover";

				var notice = null;

				$scope.formData = {};
				$scope.formData.id = $("#tourismid").val();

				$scope.del = function(id) {
					crudService.del({
						"id" : id
					}, delFileUrl).success(function() {
						updateView();
					});
				}

				$scope.cover = function(id) {
					crudService.del({
						"id" : id
					}, coverFileUrl).success(function() {
						updateView();
					});
				}

				function updateView() {
					crudService.findAllList($scope, {
						"id" : $scope.formData.id
					}, fileListUrl).success(function(data) {
						$scope.imgList = data;
					});
				}

				function showNotice(content) {

					if (notice != null) {
						notice.close({
							ignoreDelay : true
						});
					}
					notice = new jBox("Notice", {
						content : content,
						position : {
							x : "center",
							y : "center"
						},
						autoClose : 5000
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
						var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
						uploader.clearQueue();
						return this.queue.length < 1 && '|jpg|png|jpeg|bmp|'.indexOf(type) !== -1;
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
				uploader.onCompleteItem = function(fileItem, data, status, headers) {
					showNotice(data.message);
					if (data.code == "200") {
						updateView();
					}
				};
				uploader.onCompleteAll = function() {
					updateView();
					uploader.clearQueue();
				};

				updateView();

				document.getElementById("img_type").onchange = function() {
					var type = $("#img_type").val();
					if (type == "0") {
						showNotice("请选择图片大小为640*225");
					} else if (type == "1") {
						showNotice("请选择图片大小为320*220");
					} else if (type == "2") {
						showNotice("请选择图片大小为600*250");
					} else if (type == "3") {
						showNotice("请选择图片大小为200*200");
					}
					if (type != "") {
						document.getElementById("select-file").style.display = "inline-block";
						$scope.formData.type = type;
					} else {
						document.getElementById("select-file").style.display = "none";
					}
				};

			} ]);
});