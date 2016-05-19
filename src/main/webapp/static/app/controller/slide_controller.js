'use strict';

App.controller('SlideController', ['$scope', '$log', 'SlideService',function($scope, $log, SlideService){
	self = this;
	self.slide={};
	self.slides=[];
	
	self.create = function(){
		SlideService.create(self.slide)
			.then(
					function(response){
						console.log(response);
					},
					function(errResponse){
						$log.error("Error on create!")
					}
			);
	};
	
}]);