angular.module("MainApp",['ngRoute']);

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

angular.module("MainApp").controller('BillingController', function ($http, $scope) {
    $scope.send = function() {
        var billingAddress = {
            customerId: $scope.billingCustomerId,
            fullName: $scope.billingFullName,
            line1: $scope.billingLine1,
            line2: $scope.billingLine2,
            city: $scope.billingCity,
            state: $scope.billingState,
            zipCode: $scope.billingZipCode,
            billing: true
        };

        $http({
            url:"localhost:8723/shopping/billing/address/insert",
            method: "POST",
            data: billingAddress
        }).then(function(response) {
            // reset form
            $scope.billingCustomerId = "";
            $scope.billingFullName = "";
            $scope.billingLine1 = "";
            $scope.billingLine2 = "";
            $scope.billingCity = "";
            $scope.billingState = "";
            $scope.billingZipCode = "";
        }, function(response) {
            console.log("Errors in data you're sending");
        });
    }
});
