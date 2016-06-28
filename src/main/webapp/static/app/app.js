'use strict';

var App = angular.module('praiser',['ngMaterial', 'ngMessages', 'angularFileUpload', 'ngSanitize', 'validation.match']);

// ***** Angular Material *****
App.config(['$mdThemingProvider', '$httpProvider', function($mdThemingProvider, $httpProvider) {
	$mdThemingProvider.theme('default').primaryPalette('light-green').accentPalette('green');
	
		
	
	$httpProvider.defaults.useXDomain = true;
	$httpProvider.defaults.withCredentials = true;
	delete $httpProvider.defaults.headers.common["X-Requested-With"];
	$httpProvider.defaults.headers.common["Accept"] = "application/json";
	$httpProvider.defaults.headers.common["Content-Type"] = "application/json";
}]);
