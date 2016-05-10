'use strict';

App.controller('ExploreController', ['$scope', '$mdDialog', '$mdMedia', 'ExploreService', function($scope, $mdDialog, $mdMedia, ExploreService){
	var self = this;
	self.explore={};
	self.explores=[{nome:'Hozana 212'},{nome:'1'},{nome:'2'},{nome:'2'},{nome:'2'},{nome:'2'},{nome:'2'},{nome:'2'},{nome:'2'},{nome:'2'}];
	
	var CLASS = ['#b388ff', '#388e3c', '#80d8ff', '#fb8c00', '#1976d2', '#ff7043', '#dd2c00', '#ffcc80', '#e64a19', '#CDAD00', '#FFA07A', '#EE6A50', '#CD6090','#B23AEE'];
	var WIDTH = ['40%','56.5%','56.5%','40%','40%','56.5%','56.5%','40%','40%','56.5%'];
	var MARGIN = ['0em 0em 2em 0em','0em 0em 2em 2em','0em 0em 2em 0em','0em 0em 2em 2em','0em 0em 2em 0em','0em 0em 2em 2em','0em 0em 2em 0em','0em 0em 2em 2em','0em 0em 2em 0em','0em 0em 2em 2em'];
	var COLOR = ['#000000', '#ffffff'];
	
	self.getExplores = function(){
		return self.explores;
	}
	
	self.viewDownload = function(ev){
		var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
		
		    $mdDialog.show({
		      controller: DialogController,
		      templateUrl: 'download',
		      parent: angular.element(document.body),
		      targetEvent: ev,
		      clickOutsideToClose:true,
		      fullscreen: useFullScreen
		    })
		        .then(function(answer) {
		          $scope.status = 'You said the information was "' + answer + '".';
		        }, function() {
		          $scope.status = 'You cancelled the dialog.';
		        });
		
	}
	
	function DialogController($scope, $mdDialog) {
		  $scope.hide = function() {
		    $mdDialog.hide();
		  };

		  $scope.cancel = function() {
		    $mdDialog.cancel();
		  };

		  $scope.answer = function(answer) {
		    $mdDialog.hide(answer);
		  };
		}
	
	self.randomTextsize = function(data){
		if(data.length <=10){
			return '3em';
		}else if(data.length > 10 && data.length <= 20){
			return '2.2em';
		}else if(data.length > 20){
				return '1.2em';
		}
	}
	
	self.randomMargin = function(index){
		return MARGIN[index];
	}
	
	self.randomWidth = function(index){
		return WIDTH[index];
	}
	
	self.randomColor = function(index) {
		console.log(Math.floor(Math.random() * CLASS.length));
		console.log(CLASS[Math.floor(Math.random() * CLASS.length)]);
	    return CLASS[Math.floor(Math.random() * CLASS.length)];
	}
	
	self.randomGrid = function(odd) {
		if(odd==false){
			return "40";
		}else{
			return "53";
		}
	}
	
	
	self.gridList = (function(){
		var tiles = [];
		for(var i=0;i<self.explores.length;i++){
		      tiles.push({
		        color: self.randomColor(i),
		        margin: self.randomMargin(i),
		        width: self.randomWidth(i),
		        textSize: self.randomTextsize(self.explores[i].nome)
		      });
		}
		return tiles;
	})();
	
//	self.list = function(){
//		ExploreService.list()
//			.then(
//					function(allExplores){
//						self.explores = allExplores;
//					},
//					function(errResponse){
//						console.error("Erro ao buscar as explores (fetchAllExplores)");
//					}
//			);
//	};
//	
//	self.get = function(codExplore){
//		ExploreService.get(codExplore)
//			.then(
//					function(explore){
//						self.explore = explore;
//					},
//					function(errResponse){
//						console.error("Erro ao atualizar uma explore (updateExplore)");
//					}
//			
//			);
//	};
//	
//	self.create = function(explore){
//		ExploreService.create(explore)
//			.then(
//					self.list,
//					function(errResponse){
//						console.error("Erro ao atualizar uma explore (updateExplore)");
//					}
//			
//			);
//	};
//	
//	self.update = function(explore){
//		ExploreService.update(explore)
//			.then(
//					self.list,
//					function(errResponse){
//						console.error("Erro ao atualizar uma explore (updateExplore)");
//					}
//			
//			);
//	};
//	
//	self.remove = function(codExplore, event){
//		var confirm = $mdDialog.confirm()
//			.title('Excluir registro!')
//			.textContent('Deseja realmente excluir este registro?')
//			.ariaLabel('Lucky day')
//			.targetEvent(event)
//			.ok('Sim')
//			.cancel('Não');
//
//		$mdDialog.show(confirm).then(function() {
//			ExploreService.remove(codExplore)
//			.then(
//					self.list,
//					function(errResponse){
//						console.error("Erro ao deletar uma explore (deleteExplore)");
//					}
//			
//			);
//		}, function() {
//			console.log("NÃO");
//		});
//	};
//	
//	self.list();
//	
//	self.submit = function(){
//		console.log('Salvando usuário ', self.explore.codExplore);
//		if(self.explore.codExplore == null){
//			self.create(self.explore);
//		}else{
//			self.update(self.explore);
//		}
//		self.reset();
//	};
//	
//	self.reset = function(){
//		self.explore = {};
//		$scope.myForm.$setPristine();
//		$scope.myForm.$setUntouched();
//	};
//	
}]);
