'use strict';

var App = angular.module('praizer',['ngMessages']);

App.config(function($mdThemingProvider) {
	$mdThemingProvider.theme('default').primaryPalette('green').accentPalette('green');
});
