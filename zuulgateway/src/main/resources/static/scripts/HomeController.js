angular.module("MainApp").controller('HomeController', function ($scope, $http, $rootScope) {
    $http({
        url: '/product',
        method: 'GET'
    }).then(function (response) {
        $scope.products = response.data;
    }, function () {
        alert("Failure");
    });
    $scope.viewProductPage = function(product) {
        $rootScope.product = product;
    };
});