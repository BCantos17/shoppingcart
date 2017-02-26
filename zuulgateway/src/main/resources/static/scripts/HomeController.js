angular.module("MainApp").controller('HomeController', function ($scope, $http) {
    $http({
        url: '/product',
        method: 'GET'
    }).then(function (response) {
        $scope.products = response.data;
    }, function () {
        alert("Failure");
    });
});