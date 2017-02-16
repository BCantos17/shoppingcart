angular.module("MainApp",['ngRoute']);

angular.module("MainApp").controller("MainController", function($scope){

}).config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '../partials/home.html',
        controller: 'HomeController'
    });
});

angular.module("MainApp").controller('HomeController', function(){

});
