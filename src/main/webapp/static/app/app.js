'use strict';

var App = angular.module('praiser',['ngMaterial', 'ngMessages', 'angularFileUpload', 'ngSanitize', 'validation.match']);

// ***** Angular Material *****
App.config(['$mdThemingProvider', '$httpProvider', '$locationProvider', function($mdThemingProvider, $httpProvider, $locationProvider) {
	$mdThemingProvider.theme('default').primaryPalette('light-green').accentPalette('green');
	
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: false
		}).hashPrefix('!');
	
	
	$httpProvider.defaults.useXDomain = true;
	$httpProvider.defaults.withCredentials = true;
	delete $httpProvider.defaults.headers.common["X-Requested-With"];
	$httpProvider.defaults.headers.common["Accept"] = "application/json";
	$httpProvider.defaults.headers.common["Content-Type"] = "application/json";
}]);
