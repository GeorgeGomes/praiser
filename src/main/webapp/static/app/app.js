'use strict';

var App = angular.module('praiser',['ngMaterial', 'ngMessages', 'angularFileUpload', 'ngSanitize']);

// ***** Angular Material *****
App.config(function($mdThemingProvider) {
	$mdThemingProvider.theme('default').primaryPalette('light-green').accentPalette('green');
});
