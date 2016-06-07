'use strict';

var App = angular.module('praiser',['ngMaterial', 'ngMessages', 'angularFileUpload', 'ngSanitize']);

// ***** Angular Material *****
App.config(function($mdThemingProvider, $httpProvider) {
	$mdThemingProvider.theme('default').primaryPalette('light-green').accentPalette('green');
	
	$httpProvider.defaults.useXDomain = true;
	$httpProvider.defaults.withCredentials = true;
	delete $httpProvider.defaults.headers.common["X-Requested-With"];
	$httpProvider.defaults.headers.common["Accept"] = "application/json";
	$httpProvider.defaults.headers.common["Content-Type"] = "application/json";
});