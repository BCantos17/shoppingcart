angular.module("MainApp",['ngRoute']);

angular.module("MainApp").config(function($logProvider){
        $logProvider.debugEnabled(true);
});
angular.module("MainApp").controller("MainController", function($scope){

}).config(function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix("");
    $routeProvider.when('/', {
        templateUrl: '../partials/home.html',
        controller: 'HomeController'
    }).when('/Cart', {
        templateUrl:"../partials/cart.html",
        controller:'CartController'
    }).when('/Billing', {
        templateUrl:'../partials/billing.html',
        controller:'BillingController'
    });
});

angular.module("MainApp").controller('HomeController', function($scope){


});

angular.module("MainApp").controller('CartController', function ($scope) {
    $scope.price = 22;
    $scope.quantity = 10;
    $scope.subtotal = $scope.price * $scope.quantity;
});
