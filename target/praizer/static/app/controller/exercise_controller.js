'use strict';

App.controller('ExerciseController', ['$scope', '$mdDialog', 'ExerciseService', 'ExerciseFactory', 'MuscleGroupFactory',function($scope, $mdDialog, ExerciseService, ExerciseFactory, MuscleGroupFactory){
	var self = this;
	self.exercise= {};
	self.exercises=[];
	self.muscleGroups = [];
	
	MuscleGroupFactory.listMuscleGroup().then(
			function(response){
				self.muscleGroups = response;
				console.log(self.muscleGroups);
			},
			function(errResponse){
				console.error("Erro ao buscar as exercises (fetchAllExercises)");
			}
	);
	
	self.list = function(){
		ExerciseService.list()
			.then(
					function(allExercises){
						self.exercises = allExercises;
					},
					function(errResponse){
						console.error("Erro ao buscar as exercises (fetchAllExercises)");
					}
			);
	};
	
	self.get = function(codExercise){
		ExerciseService.get(codExercise)
			.then(
					function(exercise){
						self.exercise = exercise;
					},
					function(errResponse){
						console.error("Erro ao atualizar uma exercise (updateExercise)");
					}
			
			);
	};
	
	self.create = function(exercise){
		ExerciseService.create(exercise)
			.then(
					self.list,
					function(errResponse){
						console.error("Erro ao atualizar uma exercise (updateExercise)");
					}
			
			);
	};
	
	self.update = function(exercise){
		ExerciseService.update(exercise)
			.then(
					self.list,
					function(errResponse){
						console.error("Erro ao atualizar uma exercise (updateExercise)");
					}
			
			);
	};
	
	self.remove = function(codExercise, event){
		var confirm = $mdDialog.confirm()
			.title('Excluir registro!')
			.textContent('Deseja realmente excluir este registro?')
			.ariaLabel('Lucky day')
			.targetEvent(event)
			.ok('Sim')
			.cancel('Não');

		$mdDialog.show(confirm).then(function() {
			ExerciseService.remove(codExercise)
			.then(
					self.list,
					function(errResponse){
						console.error("Erro ao deletar uma exercise (deleteExercise)");
					}
			
			);
		}, function() {
			console.log("NÃO");
		});
	};
	
	self.list();
	
	self.submit = function(){
		console.log('Salvando usuário ', self.exercise.codExercise);
		if(self.exercise.codExercise == null){
			self.create(self.exercise);
		}else{
			self.update(self.exercise);
		}
		self.reset();
	};
	
	self.reset = function(){
		self.exercise = {};
		$scope.myForm.$setPristine();
		$scope.myForm.$setUntouched();
	};
	
}]);