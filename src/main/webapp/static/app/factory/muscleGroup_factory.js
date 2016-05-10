'use strict';

App.factory('MuscleGroupFactory', ['$q', 'MuscleGroupService', function($q, MuscleGroupService){	
	
	return {
		listMuscleGroup : function(){
			var q = $q.defer();
			
			MuscleGroupService.list()
				.then(
					function(response){
						console.log(response)
						q.resolve(response);
					},
					function(errResponse){
						console.error("Erro ao buscar as muscleGroups (fetchAllMuscleGroups)");
						q.reject(errResponse);
					}
				);
			
			 return q.promise;
		}
		
	};
}])