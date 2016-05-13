'use strict';

App.factory('UserService', ['$http', '$q', '$location', '$log', function($http, $q, $location, $log){
	
	return{
		list: function(){
			return $http.get($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/user/')
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
			return $http.get($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/user/' + codExercise)
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
		
		create: function(user){
			return $http.post($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/user/', user)
					.then(
							function(response){
								$log.debug("#Create user");
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching exercises');
								return $q.reject(errResponse);
							}
					);
		},
		
		update: function(exercise){
			return $http.put($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/user/', exercise)
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
			return $http.delete($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/user/' + codExercise)
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