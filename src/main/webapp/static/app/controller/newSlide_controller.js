'use strict';

App.controller('SlideController', ['$scope', '$log', '$sce', '$mdDialog', '$location', 'SlideService', 'FontService', 'BackgroundService', function($scope, $log, $sce, $mdDialog, $location, SlideService, FontService, BackgroundService){
	self = this;
	self.slide={};
	self.slides=[];
	
	console.log(getSegment($location.absUrl(), 4));
	
	self.editMode = false;
	
	self.fonts=[];
	self.backgrounds=[];
	
	var apiMusic = "https://api.vagalume.com.br/search.artmus?limit=8&q=";
	
	self.visibleBtnSlideEdit = true;
	self.visibleBtnSlideConfirm = false;
	

	self.phases=[];
	
	self.statusUpload = true;
	self.statusPersonalize = false;
	
	self.downloadStep = 1;
	
	self.music="";
	self.lyrics=[];
	self.selectLyricId="";
	
	self.slideEditIndex = 0;
	
	self.ratio="4:3";
	self.slideFontSize = 4;//em
	
	
	//self.slideFont = 'arial';
	
	//self.slideBackground = '';
	self.background = {};
	self.font = {};
	
	
	self.slideColorBody = '#000000';
	self.slideColorTitle = "#000000";
	//16:9 -  1777px 1000px
	//4:3  - 1333px 1000px
	self.slideWidth = '1333';//px
	self.slideHeight = '1000';//px
	
	
	self.btnSlideEdit = function(){
		$("#slideStage div").attr('contenteditable','true');
		$("#slideStage div").focus();
		$("#slideStage").removeClass("alignCenterStage");
	
		self.visibleBtnSlideEdit = false;
		self.visibleBtnSlideConfirm = true;
	}
	
	self.btnSlideConfirm = function(){
		$(".slideStage div").attr('contenteditable','false');

		self.phases[self.slideEditIndex] = $("#slideStageContent").html();
		$('#mySlide').modal('hide');
		
		self.visibleBtnSlideEdit = true;
		self.visibleBtnSlideConfirm = false;
	}
	
	self.btnSlideCancel = function(){
		$('#mySlide').modal('hide');
		
		self.visibleBtnSlideEdit = true;
		self.visibleBtnSlideConfirm = false;
	}
	
	self.editMouseOver = function(slideEdit){
		$('#'+slideEdit).css("opacity",0.5);
	}
	
	self.editMouseLeave = function(slideEdit){
		$('#'+slideEdit).css("opacity",0);
	}
	
	self.back = function(){
		self.statusUpload = true;
		self.statusPersonalize = false;
	}
	
	self.selectRatio = function(ratio){
		if(ratio=="4:3"){
			self.slideWidth = 1333;
			self.slideHeight = 1000;
			self.ratio = ratio;
		}else if(ratio=="16:9"){
			self.slideWidth = 1777;
			self.slideHeight = 1000;
			self.ratio = ratio;
		}
	}
	
	self.selectMusic = function(lyric){
		self.selectLyricId = lyric.id;
		self.music = lyric.title + " - " + lyric.band;	
		self.lyrics=[];
	}

	self.searchMusic = function(){
		
		if(self.music.length >= 4){
			
			self.lyrics = {"response":{"numFound":17557,"start":0,"docs":[{"id":"l3ade68b8g462850b3","langID":1,"url":"/wesley-safadao/vou-dar-virote.html","title":"Vou Dar Virote","band":"Wesley Safadão"},{"id":"l3ade68b8gcc7f80b3","langID":1,"url":"/jorge-e-mateus/vou-voando.html","title":"Vou Voando","band":"Jorge e Mateus"},{"id":"l3ade68b8gb86770b3","langID":2,"url":"/rihanna/dance-in-the-dark.html","title":"Dance In The Dark","band":"Rihanna"},{"id":"l3ade68b8g28dc30b3","langID":2,"url":"/katy-perry/dark-horse-feat-juicy-j.html","title":"Dark Horse (Feat. Juicy J)","band":"Katy Perry"},{"id":"l3ade68b8g99bb40b3","langID":2,"url":"/shakira/dare-la-la-la.html","title":"Dare (La La La)","band":"Shakira"},{"id":"b3ade68b5g3ce8eda3","url":"/sampa-crew/","band":"Sampa Crew"},{"id":"b3ade68b7g41272ea3","url":"/vou-zuar/","band":"Vou Zuar"},{"id":"b3ade68b6g0f4aeda3","url":"/darvin/","band":"Darvin"},{"id":"b3ade68b5gded8eda3","url":"/daryl-hall-john-oates/","band":"Daryl Hall & John Oates"},{"id":"b3ade68b7gbf5d0ea3","url":"/grupo-vou-pro-sereno/","band":"Grupo Vou Pro Sereno"}]},"highlighting":{"l3ade68b8g462850b3":{"letra":[" noite não tem hora pra acabar\n\nEu <em>vou</em> <em>dar</em> virote, eu <em>vou</em> <em>dar</em> virote\nEu sou patrão to estourado e essa"],"title":["<em>Vou</em> <em>Dar</em> <em>Virote</em>"]},"l3ade68b8gcc7f80b3":{"letra":[" você tá tão ruim, oh, oh, oh\n\nAmanheceu\nE no meu sonho teu sorriso me chamando\nEu <em>vou</em> voando e eu <em>vou</em>"],"title":["<em>Vou</em> Voando"]},"l3ade68b8gb86770b3":{"title":["Dance In The <em>Dar</em>k"]},"l3ade68b8g28dc30b3":{"letra":["\n\nSo you wanna play with magic\nBoy, you should know whatcha falling for\nBaby do you <em>dare</em> to do this"],"title":["<em>Dar</em>k Horse (Feat. Juicy J)"]},"l3ade68b8g99bb40b3":{"letra":["La la la la la\nLa la la la la\nLa la la la la\nLa la la la la\n\nI <em>dare</em> you\n(Leggo, leggo, leggo, leggo"],"title":["<em>Dar</em>e (La La La)"]},"b3ade68b5g3ce8eda3":{},"b3ade68b7g41272ea3":{"band":["<em>Vou</em> Zuar"]},"b3ade68b6g0f4aeda3":{"band":["<em>Dar</em>vin"]},"b3ade68b5gded8eda3":{"band":["<em>Dar</em>yl Hall & John Oates"]},"b3ade68b7gbf5d0ea3":{"band":["Grupo <em>Vou</em> Pro Sereno"]}}}
			
			
//			jQuery.getJSON(
//					apiMusic + self.music, function(data) {
//						console.log( "success" );
//						console.log(data);
//						self.lyrics = data;
//					})
//					  .done(function() {
//					    console.log( "second success" );
//					  })
//					  .fail(function() {
//					    console.log( "error" );
//					  })
//					  .always(function() {
//					    console.log( "complete" );
//					  });
			
		}else{
			self.lyrics = [];
		}
	}
	
	self.changeFont = function(font){
		self.slide.font = font;
	}
	
	self.changeBackground = function(background){
		self.slide.background = background;
		//self.slideColorTitle = colorTitle;
		//self.slideColorBody = colorBody;
	}
	
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
	
	self.listSlides= function(){
		SlideService.list()
			.then(
					function(response){
						console.log("listSlides");
						console.log(response);
						self.slides = response;
					},
					function(errResponse){
						console.error("Erro ao buscar os backgrounds (listSlides)");
					}
			);
	};
	
	self.listSlides();
	
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
	
	self.selectSlide = function(index){
		self.slideEditIndex = index;
		$('#mySlide').modal();
	}
	
	self.stageChange = function(){
		var html = $(".slideStage div").html().replace(/<div>/gi,'<br>').replace(/<\/div>/gi,'');
		$(".slideStage div").html(html);
		
	}
	
	$('#mascara').css('height', $(document).height()).hide();
	
	self.newSlide = function(){
		self.phases.push("");
	}
	
	self.deleteSlide = function(ev, index){

		var confirm = $mdDialog.confirm()
						.title('Confirmação')
						.textContent('Gostaria de excluir este slide?')
						.ariaLabel('Lucky day')
						.targetEvent(ev)
						.ok('Sim')
						.cancel('Não');
		$mdDialog.show(confirm).then(function() {
			console.log("sim");
			self.phases.splice(index, 1);
		}, function() {
			console.log("não");
		});
		 
		
	}
	
	self.upload = function(){		
		
		var obj = {"music":"Nosso Deus\n\nNosso Deus é soberano\nEle reina antes a fundação do mundo\n\nA terra era sem forma e vazia\nE o espirito do nosso Deus\nSe movia sobre a face das águas\n\nFoi Ele quem criou o céu dos céus\nFez separação das águas\nE a terra seca\n\n teste teste steste teste teste teste teste\n sdsdad asd f dajfhaksd fkasf kasd f\nadh aksdhkahdkahsdk ah kdhakdakshd kahd\nasdhakdhakshdkahdkhaskdh\n"};
		var txt = JSON.stringify(obj.music);
		txt = txt.replace(/\"/g,"");
		
		self.statusUpload = false;
		self.statusPersonalize = true;
		
		self.slide.musicName = "musica";
		self.slide.artistName = "artista";
		self.slide.lyrics = txt;
		
		self.phases = txt.split("\\n\\n");
		
		for(var x=0; x < self.phases.length; x++){
			var txt = '';
			var arr = self.phases[x].split("\\n");
			for(var i=0; i < arr.length; i++){
				txt += "<div>" + arr[i] + "</div>";
			}
			self.phases[x] = "<div>"+txt+"</div>";
		}

		
//		SlideService.searchLyric(self.selectLyricId)
//		.then(
//			function(response){
//				
//				var txt = JSON.stringify(response.mus[0].text);
//				
//				self.statusUpload = false;
//				self.statusPreview = true;
//				self.statusPersonalize = true;
//				
//				self.phases = txt.split("\\n\\n");
//				
//				for(var x=0; x < self.phases.length; x++){
//					var txt = '';
//					var arr = self.phases[x].split("\\n");
//					for(var i=0; i < arr.length; i++){
//						txt += "<div>" + arr[i] + "</div>";
//					}
//					self.phases[x] = "<div>"+txt+"</div>";
//				}
//				
//				
//			},
//			function(errResponse){
//				$log.error("Error on create!")
//			}
//		);
		

	}
	
	self.htmlDecode = function (myHtml){
		return myHtml.replace(/&amp;/g, "&").replace(/&gt;/g, ">").replace(/&lt;/g, "<");
		//return $('<div/>').html(input).html();
	}

	self.personalize = function(){
		console.log(self.slide.musicLetter);
		console.log($("#musicLetter").val());
		
		
		
		
		//var txt = $sce.trustAsHtml($("#musicLetter").val());
		//var music = self.htmlDecode($("#musicLetter").val());
		var music = $("#musicLetter").val();
		self.phases = music.split("<hr>");
		self.statusUpload = false;
		self.statusPersonalize = true;
		
//		$('.slide').overflowing('.contentSlide', function(overflowed) { 
//			console.log('This element is being overflowed', overflowed)
//		})
		
	};
	
	self.done = function(){
		self.statusUpload = false;
		self.statusPersonalize = false;
	};
	
	self.download = function(){
		self.downloadStep = 1;
		$('#myModal').modal();
	}
	
	self.resetSlide = function(){
		location = '/praiser/slide';
	}
	
	self.home = function(){
		location = '/praiser/';
	}
	
	self.saveSlide = function(){
		
		console.log("savedownloads")	
		var htmlSlides = $("#canvasSlide").html();
		console.log(htmlSlides);
		
		self.downloadStep = 2;
		
		self.slide.music="musica";
		self.slide.artist="artista";
		self.slide.slide = htmlSlides;
		self.slide.slidesImages = [];
		self.slide.width = self.slideWidth;
		self.slide.height = self.slideHeight;
		
		var tot = 1;
		$("#canvasSlide").show();
		$(".slideSave").each(function(){			
			
			html2canvas($(this), {
	            onrendered: function(canvas) {
	                var myImage = canvas.toDataURL("image/jpeg");
	                //window.open(myImage)
	                self.slide.slidesImages.push(myImage)
	                if(tot==$(".slideSave").length){
	                	$("#canvasSlide").hide();
	                	self.create();
	                }
	                tot++
	            }
	        });
		})
		
	}
	
	self.saveSlide1 = function(){
		
		var htmlSlides = $("#canvasSlide").html();
		
		self.downloadStep = 2;
		
		
		
		//self.slide.font = self.font;
		//self.slide.slide = htmlSlides;
		//self.slide.slidesImages = [];
		//self.slide.width = self.slideWidth;
		//self.slide.height = self.slideHeight;
		
		var tot = 1;
		$("#canvasSlide").show();
		
		
//		$(".slideSave").each(function(){			
//			
//			html2canvas($(this), {
//	            onrendered: function(canvas) {
//	                var myImage = canvas.toDataURL("image/jpeg");
//	                //window.open(myImage)
//	                self.slide.slidesImages.push(myImage)
//	                if(tot==$(".slideSave").length){
//	                	$("#canvasSlide").hide();
//	                	self.create();
//	                }
//	                tot++
//	            }
//	        });
//		})
		
		self.createImageSlide(self.createImageSlide, 0);
		
	}
	
	self.saveSlide2 = function(){
		
		//var htmlSlides = $("#canvasSlide").html();
		
		self.downloadStep = 2;

		//self.slide.font = self.font;
		//self.slide.slide = htmlSlides;
		//self.slide.slidesImages = [];
		//self.slide.width = self.slideWidth;
		//self.slide.height = self.slideHeight;
		
		//var tot = 1;
		//$("#canvasSlide").show();
		
		
//		$(".slideSave").each(function(){			
//			
//			html2canvas($(this), {
//	            onrendered: function(canvas) {
//	                var myImage = canvas.toDataURL("image/jpeg");
//	                //window.open(myImage)
//	                self.slide.slidesImages.push(myImage)
//	                if(tot==$(".slideSave").length){
//	                	$("#canvasSlide").hide();
//	                	self.create();
//	                }
//	                tot++
//	            }
//	        });
//		})
		
		//self.createImageSlide(self.createImageSlide, 0);
		self.create();
		
	}
	self.createImageSlide = function(callback, index){
		var obj = $(".slideSave:eq("+index+")"); 
		
		$(".slideSave:eq("+index+")").each(function(){	
		html2canvas($(this), {
				onrendered: function(canvas) {
	        	   var myImage = canvas.toDataURL("image/jpeg");
	               self.slide.slidesImages.push(myImage)
	               
	               if((index + 1) == $(".slideSave").length){
	            	   	$("#canvasSlide").hide();
	               		self.create();
	               }else{
	            	   callback(callback, index+1)
	               }
	           }
		});
		});
	}
	
	self.create = function(){
		SlideService.create(self.slide)
			.then(
					function(response){
						self.downloadStep = 3;
						console.log(response);
						console.log(response.slideId)
						location = "/praiser/slide/"+response.slideId;
					},
					function(errResponse){
						$log.error("Error on create!")
					}
			);
	};
	
	
}]);
