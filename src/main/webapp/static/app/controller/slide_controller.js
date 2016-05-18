'use strict';

App.controller('SlideController', ['$scope', '$log', 'SlidesService',function($scope, $log, SlidesService){
	self = this;
	self.texto = "";
	
	self.create = function(){
		SlidesService.create(self.user)
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
	
}]);