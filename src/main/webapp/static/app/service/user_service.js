'use strict';

App.factory('UserService', ['$http', '$q', '$location', '$log', function($http, $q, $location, $log){
	
	return{
		list: function(){
			return $http.get($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/auth/user/')
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
		
		get: function(){
			return $http.get($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/auth/user/current')
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
			return $http.post($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/auth/user/', user)
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
		
		update: function(user){
			return $http.put($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/auth/user/', user)
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
		
		remove: function(codUser){
			return $http.delete($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/auth/user/' + codUser)
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