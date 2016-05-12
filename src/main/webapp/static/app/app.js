'use strict';

var App = angular.module('praizer',['ngMaterial', 'ngMessages', 'material.svgAssetsCache']);

App.config(function($mdThemingProvider) {
	$mdThemingProvider.theme('default').primaryPalette('green').accentPalette('green');
});
