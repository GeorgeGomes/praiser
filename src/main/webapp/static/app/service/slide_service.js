'use strict';

App.factory('SlideService', ['$http', '$q', '$rootElement', '$location', '$log', function($http, $q, $rootElement, $location, $log){
	
	var app = $rootElement.attr('ng-app')
	var path = $location.protocol() + "://" + $location.host() + ':' + $location.port();
	
	return{		
		list: function(){
			return $http.get(path + '/' + app + '/rest/slide/list')
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
			return $http.get(path + '/' + app + '/rest/slide/get')
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								return $q.reject(errResponse);
							}
					);
			
		},
		
		create: function(slide){
			return $http.post(path + '/' + app + '/rest/slide/create', slide)
					.then(
							function(response){
								return response;
							},
							function(errResponse){
								return $q.reject(errResponse);
							}
					);
		},
		
		update: function(slide){
			return $http.put(path + '/' + app + '/rest/slide/update', slide)
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
			return $http.delete(path + '/' + app + '/rest/slide/delete/' + slideId)
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