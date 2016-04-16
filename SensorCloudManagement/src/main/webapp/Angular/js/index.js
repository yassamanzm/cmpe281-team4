var cmpe281 = angular.module('cmpe281', [ 'ngRoute' ]);

cmpe281.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'Angular/Projects/templates/default.html',
		controller : 'loginController'
	}).when('/login', {
		templateUrl : 'Angular/Projects/templates/login.html',
		controller : 'loginController'
	}).when('/signup', {
		templateUrl : 'Angular/Projects/templates/signup.html',
		controller : 'signupController'
	}).when('/home', {
		templateUrl : 'Angular/Projects/templates/home.html',
		controller : 'homeController'
	}).when('/home/sensor', {
		templateUrl : 'Angular/Projects/templates/sensor.html',
		controller : 'sensorController'
	}).otherwise({
		redirectTo : '/login'
	});
} ]);
