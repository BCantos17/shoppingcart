angular.module("MainApp",['ngRoute']);

angular.module("MainApp").controller("MainController", function($scope){

}).config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '../partials/home.html',
        controller: 'HomeController'
    }).when('/Cart', {
        templateUrl:"../partials/cart.html",
        controller:'CartController'
    });
});

angular.module("MainApp").controller('HomeController', function($scope){


});

angular.module("MainApp").controller('CartController', function ($scope) {
    $scope.price = 22;
    $scope.quantity = 10;
    $scope.subtotal = $scope.price * $scope.quantity;
});
