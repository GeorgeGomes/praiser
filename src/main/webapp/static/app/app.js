'use strict';

var App = angular.module('praizer',['ngMaterial', 'ngMessages', 'angularFileUpload']);

// ***** Angular Material *****
App.config(function($mdThemingProvider) {
	$mdThemingProvider.theme('default').primaryPalette('light-green').accentPalette('green');
});
