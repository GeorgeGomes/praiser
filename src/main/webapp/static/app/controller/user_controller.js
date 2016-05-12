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
	
	self.submitCreate = function(){
		$log.debug(console.log(self.create));
		$log.debug("Criando usuário");
		$log.debug($location.host());
		self.create();
	}
}]);