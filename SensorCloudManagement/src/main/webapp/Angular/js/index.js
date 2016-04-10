var cmpe281 = angular.module('cmpe281', [ 'ngRoute' ]);

cmpe281.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'Angular/projects/Projects/templates/default.html',
		controller : 'loginController'
	}).when('/login', {
		templateUrl : 'Angular/projects/Projects/templates/login.html',
		controller : 'loginController'
	}).when('/signup', {
		templateUrl : 'Angular/projects/Projects/templates/signup.html',
		controller : 'signupController'
	}).otherwise({
		redirectTo : '/login'
	});
} ]);
