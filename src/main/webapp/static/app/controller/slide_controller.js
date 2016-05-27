'use strict';

App.controller('SlideController', ['$scope', '$log', 'SlideService',function($scope, $log, SlideService){
	self = this;
	self.slide={};
	self.slides=[];
	
	self.musictest='';
	self.phases=[];
	
	self.statusStepOne = false;
	self.statusStepTwo = false;
	
	self.upload = function(){
		self.slide.musicLetter = self.musictest;
		self.musictest = "";
		self.statusStepOne = true;
	}
	
	self.stepOne = function(){
		self.phases = self.slide.musicLetter.split("\n\n");
		self.statusStepOne = false;
		self.statusStepTwo = true;
	};
	
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