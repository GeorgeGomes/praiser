'use strict';


App.controller('SignupController', ['$scope', '$log', 'UserService', '$location', function($scope, $log, UserService, $location){
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
		$log.debug(console.log(self.create));
		$log.debug("Criando usuário");
		$log.debug($location.host());
		self.create();
	}
	
	self.get();
	
}]);