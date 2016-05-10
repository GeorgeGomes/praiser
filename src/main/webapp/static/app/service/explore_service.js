'use strict';

App.factory('ExploreService', ['$http', '$q', function($http, $q){
	
	return{
		list: function(){
			return $http.get('/stronger/rest/explore/')
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching explores');
								return $q.reject(errResponse);
							}
					);
			
		},
		
		get: function(codExplore){
			return $http.get('/stronger/rest/explore/' + codExplore)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching explores');
								return $q.reject(errResponse);
							}
					);
			
		},
		
		create: function(explore){
			return $http.post('/stronger/rest/explore/', explore)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching explores');
								return $q.reject(errResponse);
							}
					);
		},
		
		update: function(explore){
			return $http.put('/stronger/rest/explore/', explore)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching explores');
								return $q.reject(errResponse);
							}
					);
		},
		
		remove: function(codExplore){
			return $http.delete('/stronger/rest/explore/' + codExplore)
					.then(
							function(response){
								return response.data;
							},
							function(){
								console.error('Error while deleting explore');
								return $q.reject(errResponse);
							}
					);
		}
	};
	
}]);