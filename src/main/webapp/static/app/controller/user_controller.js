'use strict';

App.controller('UserController', ['$scope', '$log', '$rootElement', '$mdDialog', '$location', '$window', 'FileUploader', 'UserService', function($scope, $log, $rootElement, $mdDialog, $location, $window, FileUploader, UserService){
	var app = $rootElement.attr('ng-app')
	
	var self = this;
	self.user={};
	self.users=[];
	$scope.editMode = false;
	$scope.image = "/" + app + "/images/" + self.user.imageProfile;
	
	// plugin used:
	// http://nervgh.github.io/pages/angular-file-upload/examples/image-preview/
	
	$scope.uploader = new FileUploader({
		url: $location.protocol() + "://" + $location.host() + ':' + $location.port() + '/' + app + '/rest/auth/user/upload/',
		removeAfterUpload: true
	});
	
	$scope.uploader.filters.push({
            name: 'imageFilter',
            fn: function(item /* {File|FileLikeObject} */, options) {
                var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
                return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
            }
        });
		
		$scope.uploader.onWhenAddingFileFailed = function(item /* {File|FileLikeObject} */, filter, options) {
            console.info('onWhenAddingFileFailed', item, filter, options);
			
			$("#file").val('');
        }
		
		 $scope.uploader.onSuccessItem = function(fileItem, response, status, headers) {
            console.info('onSuccessItem', fileItem, response, status, headers);
			$("#file").val('');
        };
	
	
	self.edit = function(){
		$scope.editMode = true;
	}
	
	self.list = function(){
		UserService.list()
			.then(
					function(users){
						$log.debug("Users get success!")
						self.users = users;
					},
					function(errResponse){
						$log.error("Error on list!")
					}
			);
	};
	
	self.get = function(){
		UserService.get()
			.then(
					function(user){
						$log.debug("User get success!")
						self.user = user;
						console.log(self.user)
					},
					function(errResponse){
						$log.error("Error on get!")
					}
			
			);
	};
	

	
	self.create = function(){
		UserService.create(self.user)
			.then(
					function(response){
						console.log(response);
						if(response.status == 201){
							$log.debug("User created!")
							var url = $location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/';
							$window.location.href = url; 
						}
					},
					function(errResponse){
						$log.error("Error on create!")
					}
			);
	};
		
	self.update = function(){
		UserService.update(self.user)
			.then(
					function(user){
						$log.debug("User updated!")
					},
					function(errResponse){
						$log.error("Error on update!")
					}
			
			);
	};
	
	
	self.delete = function(userId, event){
		var confirm = $mdDialog.confirm()
			.title('Excluir registro!')
			.textContent('Deseja realmente excluir este registro?')
			.targetEvent(event)
			.ok('Sim')
			.cancel('Não');

		$mdDialog.show(confirm).then(function() {
			UserService.delete(userId)
			.then(
					function(){
						$log.debug("User deleted!");
						self.list;
					},
					function(errResponse){
						$log.error("Error on delete!");
					}
			
			);
		}, function() {
			$log.debug("No");
		});
	};
	
	self.submit = function(){
		$log.debug("Submit user!");
		if(self.user.userId == null){
			$log.debug("Create user!");
			self.create(self.user);
		}else{
			$log.debug("Update user!");
			self.update(self.user);
		}
		self.reset();
	};
	
	self.reset = function(){
		self.user = {};
		$scope.myForm.$setPristine();
		$scope.myForm.$setUntouched();
	};
	
	self.get();
	
	
	
}]);