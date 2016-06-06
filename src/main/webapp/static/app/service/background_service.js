'use strict';

App.factory('BackgroundService', ['$http', '$q', '$rootElement', '$location', function($http, $q, $rootElement, $location){
	
	var app = $rootElement.attr('ng-app')
	var path = $location.protocol() + "://" + $location.host() + ':' + $location.port();
	
	return{
		list: function(){
			return $http.get(path + '/' + app + '/rest/admin/background/list')
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
			return $http.get(path + '/' + app + '/rest/admin/background/get')
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								return $q.reject(errResponse);
							}
					);
			
		},
		
		create: function(background){
			return $http.post(path + '/' + app + '/rest/admin/background/create', background)
					.then(
							function(response){
								return response;
							},
							function(errResponse){
								return $q.reject(errResponse);
							}
					);
		},
		
		update: function(background){
			return $http.put(path + '/' + app + '/rest/admin/background/update', background)
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
			return $http.delete(path + '/' + app + '/rest/admin/background/delete/' + slideId)
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