'use strict';

App.factory('ExerciseService', ['$http', '$q', function($http, $q){
	
	return{
		list: function(){
			return $http.get('http://10.10.6.125:8090/stronger/rest/exercise/')
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching exercises');
								return $q.reject(errResponse);
							}
					);
			
		},
		
		get: function(codExercise){
			return $http.get('http://10.10.6.125:8090/stronger/rest/exercise/' + codExercise)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching exercises');
								return $q.reject(errResponse);
							}
					);
			
		},
		
		create: function(exercise){
			console.log("create:");
			console.log(exercise);
			return $http.post('http://10.10.6.125:8090/stronger/rest/exercise/', exercise)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching exercises');
								return $q.reject(errResponse);
							}
					);
		},
		
		update: function(exercise){
			return $http.put('http://10.10.6.125:8090/stronger/rest/exercise/', exercise)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching exercises');
								return $q.reject(errResponse);
							}
					);
		},
		
		remove: function(codExercise){
			return $http.delete('http://10.10.6.125:8090/stronger/rest/exercise/' + codExercise)
					.then(
							function(response){
								return response.data;
							},
							function(){
								console.error('Error while deleting exercise');
								return $q.reject(errResponse);
							}
					);
		}
	};
	
}]);