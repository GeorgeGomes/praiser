'use strict';

App.factory('SlideService', ['$http', '$q', '$location', '$log', function($http, $q, $location, $log){
	
	return{		
		list: function(){
			return $http.get($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/slide/list')
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
			return $http.get($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/slide/get')
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
			console.log(slide)
			return $http.post($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/slide/create', slide)
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
			return $http.put($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/slide/update', slide)
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
			return $http.delete($location.protocol() + "://" + $location.host() + ':' + $location.port() + '/praizer/rest/slide/delete' + slideId)
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