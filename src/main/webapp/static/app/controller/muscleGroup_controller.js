'use strict';

App.controller('MuscleGroupController', ['$scope', '$mdDialog', 'MuscleGroupService', function($scope, $mdDialog, MuscleGroupService){
	var self = this;
	self.muscleGroup={};
	self.muscleGroups=[];
	
	self.list = function(){
		MuscleGroupService.list()
			.then(
					function(allMuscleGroups){
						self.muscleGroups = allMuscleGroups;
					},
					function(errResponse){
						console.error("Erro ao buscar as muscleGroups (fetchAllMuscleGroups)");
					}
			);
	};
	
	self.get = function(codMuscleGroup){
		MuscleGroupService.get(codMuscleGroup)
			.then(
					function(muscleGroup){
						self.muscleGroup = muscleGroup;
					},
					function(errResponse){
						console.error("Erro ao atualizar uma muscleGroup (updateMuscleGroup)");
					}
			
			);
	};
	
	self.create = function(muscleGroup){
		MuscleGroupService.create(muscleGroup)
			.then(
					self.list,
					function(errResponse){
						console.error("Erro ao atualizar uma muscleGroup (updateMuscleGroup)");
					}
			
			);
	};
	
	self.update = function(muscleGroup){
		MuscleGroupService.update(muscleGroup)
			.then(
					self.list,
					function(errResponse){
						console.error("Erro ao atualizar uma muscleGroup (updateMuscleGroup)");
					}
			
			);
	};
	
	self.remove = function(codMuscleGroup, event){
		var confirm = $mdDialog.confirm()
			.title('Excluir registro!')
			.textContent('Deseja realmente excluir este registro?')
			.ariaLabel('Lucky day')
			.targetEvent(event)
			.ok('Sim')
			.cancel('Não');

		$mdDialog.show(confirm).then(function() {
			MuscleGroupService.remove(codMuscleGroup)
			.then(
					self.list,
					function(errResponse){
						console.error("Erro ao deletar uma muscleGroup (deleteMuscleGroup)");
					}
			
			);
		}, function() {
			console.log("NÃO");
		});
	};
	
	self.list();
	
	self.submit = function(){
		console.log('Salvando usuário ', self.muscleGroup.codMuscleGroup);
		if(self.muscleGroup.codMuscleGroup == null){
			self.create(self.muscleGroup);
		}else{
			self.update(self.muscleGroup);
		}
		self.reset();
	};
	
	self.reset = function(){
		self.muscleGroup = {};
		$scope.myForm.$setPristine();
		$scope.myForm.$setUntouched();
	};
	
}]);