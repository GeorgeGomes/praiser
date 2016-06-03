'use strict';

App.controller('FontController', ['$scope', '$log', '$rootElement', '$mdDialog', '$location', 'FileUploader', 'FontService', function($scope, $log, $rootElement, $mdDialog, $location, FileUploader, FontService){
	var app = $rootElement.attr('ng-app')
	
	var self=this;
	self.font={};
	self.fonts=[];
	
	self.errorUpload = false;
	
	// plugin used:
	// http://nervgh.github.io/pages/angular-file-upload/examples/image-preview/
	
	$scope.uploader = new FileUploader();
	
	$scope.uploader.filters.push({
        name: 'ttfFilter',
        fn: function(item /* {File|FileLikeObject} */, options) {
        	console.log(item.type);
        	console.log(item.name);
        	console.log(item.name.slice(item.name.lastIndexOf('.') + 1));
            var type = '|' + item.name.slice(item.name.lastIndexOf('.') + 1) + '|';
            return '|ttf|'.indexOf(type) !== -1;
        }
    });
	
	$scope.uploader.onWhenAddingFileFailed = function(item /* {File|FileLikeObject} */, filter, options) {
        console.info('onWhenAddingFileFailed', item, filter, options);
        self.errorUpload = true;
		$("#file").val('');
    }
	
	 $scope.uploader.onSuccessItem = function(fileItem, response, status, headers) {
        console.info('onSuccessItem', fileItem, response, status, headers);
        self.errorUpload = false;
		$("#file").val('');
    };
	
	$scope.uploader.onBeforeUploadItem = function(item) {
		console.log("before");
		//item.formData.push(self.font);
		 
		item.url = $location.protocol() + "://" + $location.host() + ':' + $location.port() + '/' + app + '/rest/admin/font/upload/' + self.font.fontId;
		item.removeAfterUpload = true;
		
	};
    
	self.list = function(){
		FontService.list()
			.then(
					function(response){
						self.fonts = response;
					},
					function(errResponse){
						console.error("Erro ao buscar as fonts (fetchAllFonts)");
					}
			);
	};
	
	self.get = function(fontId){
		FontService.get(fontId)
			.then(
					function(font){
						self.font = font;
					},
					function(errResponse){
						console.error("Erro ao atualizar uma font (updateFont)");
					}
			
			);
	};
	
	self.create = function(font){
		FontService.create(font)
			.then(
					function(response){
						self.font = response.data;
						self.list;
					},
					function(errResponse){
						console.error("Erro ao atualizar uma font (updateFont)");
					}
			
			);
	};
	
	self.update = function(font){
		FontService.update(font)
			.then(
					self.list,
					function(errResponse){
						console.error("Erro ao atualizar uma font (updateFont)");
					}
			
			);
	};
	
	self.remove = function(fontId, event){
		var confirm = $mdDialog.confirm()
			.title('Excluir registro!')
			.textContent('Deseja realmente excluir este registro?')
			.ariaLabel('Lucky day')
			.targetEvent(event)
			.ok('Sim')
			.cancel('Não');

		$mdDialog.show(confirm).then(function() {
			FontService.remove(fontId)
			.then(
					self.list,
					function(errResponse){
						console.error("Erro ao deletar uma font (deleteFont)");
					}
			
			);
		}, function() {
			console.log("NÃO");
		});
	};
	
	self.list();
	
	self.submit = function(){
		if(self.font.fontId == null){
			self.create(self.font);
		}else{
			self.update(self.font);
		}
		//self.reset();
	};
	
	self.reset = function(){
		self.font = {};
		$scope.myForm.$setPristine();
		$scope.myForm.$setUntouched();
	};
	
}]);