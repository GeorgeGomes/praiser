'use strict';

App.directive("ngUnique", function($http, $location, $q, $rootElement) {
	return {
		restrict: 'A',
		require: 'ngModel',
		link: function (scope, element, attrs, ngModel) {
			element.bind('blur', function (e) {
				if (!ngModel || !element.val()) return;
				//var keyProperty = scope.$eval(attrs.ngUnique);
				var currentValue = element.val();
				
				//console.log("keyProperty:" + keyProperty)
				console.log("currentValue:" + currentValue)
				
				var app = $rootElement.attr('ng-app')
				var path = $location.protocol() + "://" + $location.host() + ':' + $location.port();
				
				$http.post(path + '/' + app + '/rest/auth/user/uniqueEmail',currentValue)
							.then(
									function(response){
										if (currentValue == element.val()) {
											console.log('unique = '+ response.data);
											ngModel.$setValidity('unique', !response.data);
											scope.$broadcast('show-errors-check-validity');
										}
									},
									function(errResponse){
										ngModel.$setValidity('unique', false);
										console.log($q.reject(errResponse));
									}
							);
					
				});
		}
	}
});