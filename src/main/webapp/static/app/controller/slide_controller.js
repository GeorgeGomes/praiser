'use strict';

App.controller('SlideController', ['$scope', '$log', '$sce', 'SlideService', 'FontService', 'BackgroundService', function($scope, $log, $sce, SlideService, FontService, BackgroundService){
	self = this;
	self.slide={};
	self.slides=[];
	
	self.fonts=[];
	self.backgrounds=[];
	
	self.musictest='';
	self.phases=[];
	
	self.statusUpload = true;
	self.statusPreview = false;
	self.statusPersonalize = false;
	self.statusDone = false;
	self.rawHtml = "";
	
	self.downloadStep = 1;
	
	
	
	self.font = 'arial';
	self.background = '';
	self.colorBody = '#000000';
	self.colorTitle = "#000000";

	self.testar = function(){
		console.log("testar");

		$("[name='slide']").each(function(){
			console.log($(this).html())
			$(this).append('<div style="clear:both"></div>');
			console.log($(this).html())
			html2canvas($(this), {
	            onrendered: function(canvas) {
	                var myImage = canvas.toDataURL("image/png");
	                window.open(myImage);
	            }
	        });
		})
		  
	}
	
	self.changeFont = function(font){
		self.font = font;
	}
	
	self.changeBackground = function(background, colorTitle, colorBody){
		self.background = background;
		self.colorTitle = colorTitle;
		self.colorBody = colorBody;
	}
	
	self.listBackgrounds = function(){
		BackgroundService.list()
			.then(
					function(response){
						self.backgrounds = response;
					},
					function(errResponse){
						console.error("Erro ao buscar os backgrounds (listBackgrounds)");
					}
			);
	};
	
	self.listFonts = function(){
		FontService.list()
			.then(
					function(response){
						self.fonts = response;
					},
					function(errResponse){
						console.error("Erro ao buscar as fonts (listFonts)");
					}
			);
	};
	
	self.listFonts();
	self.listBackgrounds();
	
	self.upload = function(){
//		self.slide.musicLetter = self.musictest.replace("\n\n", "<hr/>");
		var txt = self.musictest.replace(/\\n\\n/g, "<hr>");
		txt = txt.replace(/\\n/g, "<br>")
		
		$("#musicLetter").jqteVal(txt);
		self.musictest = "";
		self.statusPreview = true;
	}
	
	self.htmlDecode = function (myHtml){
		return myHtml.replace(/&amp;/g, "&").replace(/&gt;/g, ">").replace(/&lt;/g, "<");
		//return $('<div/>').html(input).html();
	}

	self.personalize = function(){
		console.log(self.slide.musicLetter);
		console.log($("#musicLetter").val());
		
		//var txt = $sce.trustAsHtml($("#musicLetter").val());
		var music = self.htmlDecode($("#musicLetter").val());
		self.phases = music.split("<hr>");
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
		self.downloadStep = 1;
		$('#myModal').modal();
	}
	
	self.saveSlide = function(){
		
		console.log("savedownloads")
		var htmlSlides = $("#canvasSlide").html();
		console.log(htmlSlides);
		
		self.slide.music="musica";
		self.slide.artist="artista";
		self.slide.slide = htmlSlides;
		self.slide.slidesImages = [];
		
		var tot = 1;
		
		$("[name='slide']").each(function(){
			//$(this).append('<div style="clear:both"></div>');
			$(this).find("div").css("float","none")
			
			html2canvas($(this), {
	            onrendered: function(canvas) {
	                var myImage = canvas.toDataURL("image/jpeg");
	                //window.open(myImage)
	                self.slide.slidesImages.push(myImage)
	                if(tot==$("[name='slide']").length){
	                	self.create();
	                }
	                tot++
	            }
	        });
		})
		
	}
	
	self.create = function(){
		SlideService.create(self.slide)
			.then(
					function(response){
						self.downloadStep = 2;
						console.log(response);
						console.log(response.data);
						console.log(response.data.filename)
						location = "/praiser/download/"+response.data.filename;
					},
					function(errResponse){
						$log.error("Error on create!")
					}
			);
	};
	
}]);