'use strict';

App.factory('UserService', ['$http', '$q', '$rootElement', '$location', '$log', function($http, $q, $rootElement, $location, $log){
	
	var app = $rootElement.attr('ng-app')
	var path = $location.protocol() + "://" + $location.host() + ':' + $location.port();
	
	return{
		list: function(){
			return $http.get(path + '/' + app + '/rest/auth/user/list')
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
			return $http.get(path + '/' + app + '/rest/auth/user/get')
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
			return $http.post(path + '/' + app + '/rest/auth/user/create', user)
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
			return $http.put(path + '/' + app + '/rest/auth/user/update', user)
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
			return $http.delete(path + '/' + app + '/rest/auth/user/delete/' + userId)
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