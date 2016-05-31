'use strict';

App.controller('SlideController', ['$scope', '$log', '$sce', 'SlideService',function($scope, $log, $sce,SlideService){
	self = this;
	self.slide={};
	self.slides=[];
	
	self.musictest='';
	self.phases=[];
	
	self.statusUpload = true;
	self.statusPreview = false;
	self.statusPersonalize = false;
	self.statusDone = false;
	self.rawHtml = "";
	
	
	self.font = 'arial';

	self.changeFont = function(font){
		self.font = font;
	}
	
	self.upload = function(){
//		self.slide.musicLetter = self.musictest.replace("\n\n", "<hr/>");
		var txt = self.musictest.replace(/\\n\\n/g, "<hr>");
		txt = txt.replace(/\\n/g, "<br>")
		
		$("#musicLetter").jqteVal(txt);
		self.musictest = "";
		self.statusPreview = true;
	}
	
	self.personalize = function(){
		console.log(self.slide.musicLetter);
		console.log($("#musicLetter").val());
		
		//var txt = $sce.trustAsHtml($("#musicLetter").val());
		self.phases = $("#musicLetter").val().split("<hr>");
		self.statusUpload = false;
		self.statusPreview = false;
		self.statusPersonalize = true;
	};
	
	self.done = function(){
		self.statusUpload = false;
		self.statusPreview = false;
		self.statusPersonalize = false;
		self.statusDone = true;
	};
	
	self.download = function(){
		$('#myModal').modal();
	}
	
	self.saveSlide = function(){
		
		console.log("savedownloads")
		var htmlSlides = $("#canvasSlide").html();
		console.log(htmlSlides);
		
		self.slide.music="musica";
		self.slide.artist="artista";
		self.slide.slide=htmlSlides;
		
		SlideService.create(self.slide)
			.then(
					function(response){
						console.log(response);
					},
					function(errResponse){
						$log.error("Error on saveSlide!")
					}
			);
	}
	
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