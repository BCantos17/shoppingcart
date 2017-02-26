var userId = 2;
var cartId = "1";

angular.module("MainApp").controller('ProductController', function($scope, $rootScope, $http){
    $scope.product = $rootScope.product;
    $scope.selectedTab = "description";
    $scope.goToDescription = function() {
        angular.element("#reviewsTab").removeClass("active");
        angular.element("#reviews").removeClass("active");
        angular.element("#addReviewTab").removeClass("active");
        angular.element("#addReview").removeClass("active");
        angular.element("#descriptionTab").addClass("active");
        angular.element("#description").addClass("active");

    };
    $scope.goToReviews = function() {
        angular.element("#descriptionTab").removeClass("active");
        angular.element("#description").removeClass("active");
        angular.element("#addReviewTab").removeClass("active");
        angular.element("#addReview").removeClass("active");
        angular.element("#reviewsTab").addClass("active");
        angular.element("#reviews").addClass("active");
    };

    $scope.goToAddReview = function() {
        angular.element("#descriptionTab").removeClass("active");
        angular.element("#description").removeClass("active");
        angular.element("#reviewsTab").removeClass("active");
        angular.element("#reviews").removeClass("active");
        angular.element("#addReviewTab").addClass("active");
        angular.element("#addReview").addClass("active");
    };
    $scope.submitComment = function (product) {
        product.reviews.push(angular.element('#comment').val());
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
    $scope.addToCart = function (product) {
        var selectedQuantity = angular.element('#quantityInput').val();
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
});