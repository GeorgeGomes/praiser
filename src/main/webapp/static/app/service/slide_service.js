'use strict';

App.factory('SlideService', ['$http', '$q', '$rootElement', '$location', '$log', function($http, $q, $rootElement, $location, $log){
	
	var app = $rootElement.attr('ng-app')
	var path = $location.protocol() + "://" + $location.host() + ':' + $location.port();
	var apiMusic = "https://api.vagalume.com.br/search.artmus?callback=JSON_CALLBACK&limit=8&q="; 
	var apiKey = "52b46489c2423c702f15c6f883da426a"
	var apiLyric = "https://api.vagalume.com.br/search.php?callback=JSON_CALLBACK&apikey=" + apiKey + "&musid="; 
	
	return{
		searchLyric:function(idMusic){
			return $http.jsonp(apiLyric + idMusic)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						return $q.reject(errResponse);
					}
			)
		},
		
		searchMusic: function(query){
			return 
			
			
//			return $http.jsonp(apiMusic + query)
//				.then(
//						function(response){
//							return response.data;
//						},
//						function(errResponse){
//							return $q.reject(errResponse);
//						}
//				)
			
		},
		
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
		
		get: function(slideId){
			return $http.get(path + '/' + app + '/rest/slide/get/'+slideId)
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