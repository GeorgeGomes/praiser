'use strict';

App.factory('UserService', ['$http', '$q', '$location', '$log', function($http, $q, $location, $log){
	
	return{
		list: function(){
			return $http.get($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/auth/user/list')
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								return $q.reject(errResponse);
							}
					);
			
		},
		
		get: function(){
			return $http.get($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/auth/user/get')
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								return $q.reject(errResponse);
							}
					);
			
		},
		
		create: function(user){
			return $http.post($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/auth/user/create', user)
					.then(
							function(response){
								return response;
							},
							function(errResponse){
								return $q.reject(errResponse);
							}
					);
		},
		
		update: function(user){
			return $http.put($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/auth/user/update', user)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								return $q.reject(errResponse);
							}
					);
		},
		
		delete: function(userId){
			return $http.delete($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/auth/user/delete' + userId)
					.then(
							function(response){
								return response.data;
							},
							function(){
								return $q.reject(errResponse);
							}
					);
		}
	};
}]);