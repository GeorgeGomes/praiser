'use strict';

App.controller('PlayController', ['$scope', '$log', '$sce', '$mdDialog', '$location', 'SlideService', 'FontService', 'BackgroundService', function($scope, $log, $sce, $mdDialog, $location, SlideService, FontService, BackgroundService){
	self = this;
	self.slide={};
	self.slides=[];
	
	console.log(getSegment($location.absUrl(), 4));
	
	self.phases=[];
	
	self.getSlides = function(slideId){
		SlideService.get(slideId)
			.then(
				function(response){
					
					self.slide = response;
					
					self.phases = self.slide.lyrics.split("\\n\\n");
					
					for(var x=0; x < self.phases.length; x++){
						var txt = '';
						var arr = self.phases[x].split("\\n");
						for(var i=0; i < arr.length; i++){
							txt += "<div>" + arr[i] + "</div>";
						}
						self.phases[x] = "<div>"+txt+"</div>";
					}
					
					
				},
				function(errResponse){
					console.error("Erro ao buscar os backgrounds (listSlides)");
				}
		);
	}
	
	if(getSegment($location.absUrl(), 4) != undefined){
		self.getSlides(getSegment($location.absUrl(), 4));
	}else{
		console.log("new")
	}
	
	
	$scope.$on('ngRepeatFinished', function(ngRepeatFinishedEvent) {
		
		var height = $( document ).height();	
		var width = $( document ).width();
		
		$(".slidePlay").css("height", height);
		$(".slidePlay").css("font-size", width/300 + "em");

		var hash = location.hash;
		if(hash == ""){
			location.href = location.href + "#slide-1";
			hash = location.hash;
		}

		$(hash).removeClass("slideHide");
		$(hash).addClass("slideShow");
		
		

		
		
		$("body").keydown(function(e){
			    // left arrow
			    
			    console.log("down"+e.keyCode)
			    console.log("down"+e.which)
			    
			    //left
			    if ((e.keyCode || e.which) == 37 || (e.keyCode || e.which) == 65){   
			    	var hash = location.hash;
			    	var num = hash.split("-");
			    	num = parseInt(num[1]);
			    	if(num > 1){
						num--
						location.href = location.href.split("#")[0] + "#slide-" + num;

						hash = location.hash;
						$(".slidePlay").addClass("slideHide");
						$(hash).removeClass("slideHide");
						$(hash).addClass("slideShow");
					}
			    }
			    
			    //right
			    if ((e.keyCode || e.which) == 39 || (e.keyCode || e.which) == 68){
			    	var hash = location.hash;
			    	var num = hash.split("-");
			    	num = parseInt(num[1]);
	 		    	if(num < self.phases.length){
						num++
						location.href = location.href.split("#")[0] + "#slide-" + num;

						hash = location.hash;
						$(".slidePlay").addClass("slideHide");
						$(hash).removeClass("slideHide");
						$(hash).addClass("slideShow");
	 				}
			    }   
		});

		
	});
	
	
}]);

App.directive('onFinishRender', function ($timeout) {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            if (scope.$last === true) {
                $timeout(function () {
                    scope.$emit(attr.onFinishRender);
                });
            }
        }
    }
});
