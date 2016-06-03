'use strict';

App.factory('MuscleGroupService', ['$http', '$q', function($http, $q){
	
	return{
		list: function(){
			return $http.get('http://10.10.6.125:8090/stronger/rest/muscleGroup/')
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching muscleGroups');
								return $q.reject(errResponse);
							}
					);
			
		},
		
		get: function(codMuscleGroup){
			return $http.get('http://10.10.6.125:8090/stronger/rest/muscleGroup/' + codMuscleGroup)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching muscleGroups');
								return $q.reject(errResponse);
							}
					);
			
		},
		
		create: function(muscleGroup){
			return $http.post('http://10.10.6.125:8090/stronger/rest/muscleGroup/', muscleGroup)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching muscleGroups');
								return $q.reject(errResponse);
							}
					);
		},
		
		update: function(muscleGroup){
			return $http.put('http://10.10.6.125:8090/stronger/rest/muscleGroup/', muscleGroup)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching muscleGroups');
								return $q.reject(errResponse);
							}
					);
		},
		
		remove: function(codMuscleGroup){
			return $http.delete('http://10.10.6.125:8090/stronger/rest/muscleGroup/' + codMuscleGroup)
					.then(
							function(response){
								return response.data;
							},
							function(){
								console.error('Error while deleting muscleGroup');
								return $q.reject(errResponse);
							}
					);
		}
	};
	
}]);