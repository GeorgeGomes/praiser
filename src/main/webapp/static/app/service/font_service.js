'use strict';

App.factory('FontService', ['$http', '$q', '$rootElement', '$location', function($http, $q, $rootElement, $location){
	
	var app = $rootElement.attr('ng-app')
	var path = $location.protocol() + "://" + $location.host() + ':' + $location.port();
	
	return{
		list: function(){
			return $http.get(path + '/' + app + '/rest/admin/font/list')
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
			return $http.get(path + '/' + app + '/rest/admin/font/get')
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								return $q.reject(errResponse);
							}
					);
			
		},
		
		create: function(font){
			return $http.post(path + '/' + app + '/rest/admin/font/create', font)
					.then(
							function(response){
								return response;
							},
							function(errResponse){
								return $q.reject(errResponse);
							}
					);
		},
		
		update: function(font){
			return $http.put(path + '/' + app + '/rest/admin/font/update', font)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								return $q.reject(errResponse);
							}
					);
		},
		
		delete: function(slideId){
			return $http.delete(path + '/' + app + '/rest/admin/font/delete/' + slideId)
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