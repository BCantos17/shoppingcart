angular.module("MainApp").controller('HomeController', function ($scope, $http, $rootScope) {
    $http({
        url: '/product',
        method: 'GET'
    }).then(function (response) {
        $scope.products = response.data;
    }, function () {
        alert("Failure");
    });
    $scope.addToCart = function (product) {
        var selectedQuantity = angular.element('#input' + product.productId).val();
        if (selectedQuantity <= product.availableQuantity) {
            $http({
                url: '/shopping/cart/addCartItem',
                method: 'POST',
                data: {
                    "cartId": cartId,
                    "itemId": product.productId + 2,
                    "quantity": selectedQuantity,
                    "productId": product.productId,
                    "userId": userId
                }
            });
        } else {
            alert("Not enough stock. Choose a value less than " + product.availableQuantity);
        }
    };
    $scope.submitComment = function (product) {
        product.reviews.push(angular.element('#comment' + product.productId).val());
        $http({
            url: '/product',
            method: 'PUT',
            data: {
                "productId": product.productId,
                "productName": product.productName,
                "price": product.price,
                "information":product.information,
                "description": product.description,
                "manufacturer": product.manufacturer,
                "productImage": product.productImage,
                "availableQuantity": product.availableQuantity,
                "reviews": product.reviews
            }
        }).then(function () {
            alert("The review was submitted successfully");
        }, function () {
            alert("The function failed to submit");
        });
    };
    $scope.viewProductReviews = function (product) {
        $rootScope.reviews = product.reviews;
    };
    $scope.viewProductPage = function(product) {
        $rootScope.product = product;
    }
});