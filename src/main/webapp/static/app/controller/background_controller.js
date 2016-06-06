'use strict';

App.controller('BackgroundController', ['$scope', '$log', '$rootElement', '$mdDialog', '$location', 'FileUploader', 'BackgroundService', function($scope, $log, $rootElement, $mdDialog, $location, FileUploader, BackgroundService){
	var app = $rootElement.attr('ng-app')
	
	var self=this;
	self.background={};
	self.backgrounds=[];
	
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
            return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
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
		//item.formData.push(self.background);
		 
		item.url = $location.protocol() + "://" + $location.host() + ':' + $location.port() + '/' + app + '/rest/admin/background/upload/' + self.background.backgroundId;
		item.removeAfterUpload = true;
		
	};
    
	self.list = function(){
		BackgroundService.list()
			.then(
					function(response){
						self.backgrounds = response;
					},
					function(errResponse){
						console.error("Erro ao buscar as backgrounds (fetchAllBackgrounds)");
					}
			);
	};
	
	self.get = function(backgroundId){
		BackgroundService.get(backgroundId)
			.then(
					function(background){
						self.background = background;
					},
					function(errResponse){
						console.error("Erro ao atualizar uma background (updateBackground)");
					}
			
			);
	};
	
	self.create = function(background){
		BackgroundService.create(background)
			.then(
					function(response){
						self.background = response.data;
						self.list;
					},
					function(errResponse){
						console.error("Erro ao atualizar uma background (updateBackground)");
					}
			
			);
	};
	
	self.update = function(background){
		BackgroundService.update(background)
			.then(
					self.list,
					function(errResponse){
						console.error("Erro ao atualizar uma background (updateBackground)");
					}
			
			);
	};
	
	self.remove = function(backgroundId, event){
		var confirm = $mdDialog.confirm()
			.title('Excluir registro!')
			.textContent('Deseja realmente excluir este registro?')
			.ariaLabel('Lucky day')
			.targetEvent(event)
			.ok('Sim')
			.cancel('Não');

		$mdDialog.show(confirm).then(function() {
			BackgroundService.remove(backgroundId)
			.then(
					self.list,
					function(errResponse){
						console.error("Erro ao deletar uma background (deleteBackground)");
					}
			
			);
		}, function() {
			console.log("NÃO");
		});
	};
	
	self.list();
	
	self.submit = function(){
		if(self.background.backgroundId == null){
			self.create(self.background);
		}else{
			self.update(self.background);
		}
		//self.reset();
	};
	
	self.reset = function(){
		self.background = {};
		$scope.myForm.$setPristine();
		$scope.myForm.$setUntouched();
	};
	
}]);