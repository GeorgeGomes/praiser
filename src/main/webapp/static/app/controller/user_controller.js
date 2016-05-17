'use strict';


App.controller('UserController', ['$scope', '$log', 'UserService', '$location', function($scope, $log, UserService, $location){
	var self = this;
	self.user={};
	
	self.create = function(){
		UserService.create(self.user)
			.then(
					function(user){
						console.log("Usuário Criado")
					},
					function(errResponse){
						console.error("Erro");
					}
			);
	};
	
	self.get = function(){
		UserService.get()
			.then(
					function(user){
						self.user = user;
					},
					function(errResponse){
						console.error("Erro ao atualizar uma muscleGroup (updateMuscleGroup)");
					}
			
			);
	};
	
	self.submitCreate = function(){
		$log.debug("Create user!");
		$log.debug(self.user)
	}
	
	self.submitUpdate = function(){
		$log.debug("Update user!");
		$log.debug(self.user)
	};
	
//	self.get();
	
}]);