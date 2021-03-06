angular.module("MainApp", ['ngRoute']);
angular.module("MainApp").config(function ($logProvider) {
    $logProvider.debugEnabled(true);
});

var userId = 2;
var cartId = "1";

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
    }).when('/addProduct', {
        templateUrl: '../partials/addProduct.html',
        controller: 'AddProductController'
    }).when('/Overview', {
        templateUrl: '../partials/overview.html',
        controller: 'OverviewController'
    }).when('/reviews', {
        templateUrl: '../partials/reviews.html',
        controller: 'ReviewsController'
    }).when('/product/:param', {
        templateUrl: '../partials/product.html',
        controller: 'ProductController'
    });
});



angular.module("MainApp").controller('CartController', function ($scope, $http, cartService) {

    var getAllformData = {
        "cartId": cartId
    };

    $http({
        url: "/apigateway/cart/getAllCartItems",
        method: "POST",
        data: getAllformData
    }).then(function (response) {
        $scope.itemList = response.data;
        cartService.setItemList($scope.itemList);
    }, function () {
        console.log("Failed to fetch cart items");
    });

    $scope.removeItem = function (itemList, index) {
        var deleteItemformData = {
            "cartId": cartId,
            "itemId": itemList[index].itemId
        };
        $http({
            url: "/apigateway/cart/removeCartItem",
            method: "POST",
            data: deleteItemformData
        }).then(function () {
            itemList.splice(index, 1);
        }, function () {
            console.log("Failed to delete cart items");
        });
    };

    $scope.increaseItemCount = function (item) {
        var newQuantity = item.quantity + 1;
        var increaseItemCountformData = {
            "cartId": cartId,
            "itemId": item.itemId,
            "quantity": newQuantity
        };
        $http({
            url: "/apigateway/cart/updateItemQuantity",
            method: "POST",
            data: increaseItemCountformData
        }).then(function () {
            item.quantity++;
            item.itemTotal = item.quantity * item.price;
        }, function () {
            console.log("Failed to increase cart item quantity");
        });
    };

    $scope.decreaseItemCount = function (item) {
        var newQuantity = item.quantity - 1;
        var decreaseItemCountformData = {
            "cartId": cartId,
            "itemId": item.itemId,
            "quantity": newQuantity
        };
        $http({
            url: "/apigateway/cart/updateItemQuantity",
            method: "POST",
            data: decreaseItemCountformData
        }).then(function () {
            item.quantity--;
            item.itemTotal = item.quantity * item.price;
        }, function () {
            console.log("Failed to decrease cart item quantity");
        });
    }
});

angular.module("MainApp").service('cartService', function () {
    var itemList;

    var setItemList = function (pickedAddress) {
        itemList = pickedAddress;
    };


    var getItemList = function () {
        return itemList;
    };

    return {
        setItemList: setItemList,
        getItemList: getItemList
    };
});


angular.module("MainApp").controller('AddProductController', function ($scope, $http) {
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
                "information":$scope.information,
                "description": $scope.description,
                "manufacturer": $scope.manufacturer,
                "productImage": productImage,
                "availableQuantity": $scope.availableQuantity,
                "reviews": []
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

angular.module('MainApp').controller('ReviewsController', function ($scope, $rootScope) {
    $scope.reviews = $rootScope.reviews;
});

