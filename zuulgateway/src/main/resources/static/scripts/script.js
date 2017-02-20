angular.module("MainApp", ['ngRoute']);

angular.module("MainApp").config(function ($logProvider) {
    $logProvider.debugEnabled(true);
});
angular.module("MainApp").controller("MainController", function ($scope) {

}).config(function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix("");
    $routeProvider.when('/', {
        templateUrl: '../partials/home.html',
        controller: 'HomeController'
    }).when('/Cart', {
        templateUrl: "../partials/cart.html",
        controller: 'CartController'
    }).when('/Billing', {
        templateUrl: '../partials/billing.html',
        controller: 'BillingController'
    }).when('/productAccess', {
        templateUrl: '../partials/productAccess.html',
        controller: 'ProductAccessController'
    }).when('/Overview', {
        templateUrl: '../partials/overview.html',
        controller: 'OverviewController'
    });
});

angular.module("MainApp").controller('HomeController', function ($scope, $http) {
    $http({
        url: '/product',
        method: 'GET'
    }).then(function (response) {
        $scope.products = response.data;
        alert("Success");
    }, function () {
        alert("Failure");
    });
});

angular.module("MainApp").controller('CartController', function ($scope, $http, cartService) {

    var getAllformData = {
        "cartId":"58a5f3a7ffcda228089b82bc"

    $http({
        url: "http://localhost:8723/shopping/cart/getAllCartItems",
        method: "POST",
        data: getAllformData
    }).then(function(response) {
        $scope.itemList = response.data;
        cartService.setItemList($scope.itemList);
    }, function(response) {
        console.log("GET ALL: Failed to fetch cart items");
    });

    $scope.removeItem = function(itemList, index) {
        var deleteItemformData = {
            "cartId":"58a5f3a7ffcda228089b82bc",
            "itemId":itemList[index].itemId
        };
        $http({
            url: "http://localhost:8723/shopping/cart/removeCartItem",
            method: "POST",
            data: deleteItemformData
        }).then(function(response) {
            itemList.splice(index,1);
        }, function(response) {
            console.log("GET ALL: Failed to delete cart items");
        });
    };
});

angular.module("MainApp").service('cartService', function() {
    var itemList;

    var setItemList = function( pickedAddress ) { itemList = pickedAddress;};


    var getItemList = function(){return itemList;};

    return {
        setItemList: setItemList,
        getItemList: getItemList
    };
});


angular.module("MainApp").controller('ProductAccessController', function ($scope, $http) {
    var productImage;
    document.getElementById("productImage").addEventListener("change", function () {
        var file = document.querySelector('input[type=file]').files[0];
        var reader = new FileReader();

        reader.addEventListener("load", function () {
            productImage = reader.result;
        }, false);
        if (file) {
            reader.readAsDataURL(file);
        }
    });
    $scope.submitProductData = function () {
        $http({
            url: '/product',
            method: 'POST',
            data: {
                "productId": $scope.productId,
                "productName": $scope.productName,
                "price": $scope.price,
                "description": $scope.description,
                "manufacturer": $scope.manufacturer,
                "productImage": productImage,
                "availableQuantity": $scope.availableQuantity
            }
        }).then(function () {
            alert("Success");
        }, function () {
            alert("Failure");
        });
    };

    $scope.getImage = function () {
        $http({
            url: '/product',
            method: 'GET'
        }).then(function (response) {
            $scope.products = response.data;
            alert("Success");
        }, function () {
            alert("Failure");
        });
    }
});