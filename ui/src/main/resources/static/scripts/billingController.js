angular.module("MainApp").controller('BillingController', function ($http, $scope, $log) {
    $scope.send = function() {
        var billingAddress = {
            customerId: 7,
            fullName: $scope.billingFullName,
            line1: $scope.billingLine1,
            line2: $scope.billingLine2,
            city: $scope.billingCity,
            state: $scope.billingState,
            zipCode: $scope.billingZipCode,
            billing: true
        };

        $log.debug(billingAddress.fullName);

        var shippingAddress = {
            customerId: 7,
            fullName: $scope.shippingFullName,
            line1: $scope.shippingLine1,
            line2: $scope.shippingLine2,
            city: $scope.shippingCity,
            state: $scope.shippingState,
            zipCode: $scope.shippingZipCode,
            billing: false
        };

        $http({
            url:"http://localhost:8723/shopping/billing/address/insert",
            method: "POST",
            data: billingAddress
        }).then(function(response) {
            // reset form
            $scope.billingFullName = "";
            $scope.billingLine1 = "";
            $scope.billingLine2 = "";
            $scope.billingCity = "";
            $scope.billingState = "";
            $scope.billingZipCode = "";
        }, function(response) {
            console.log("Errors in data you're sending");
        });

        $http({
            url:"http://localhost:8723/shopping/billing/address/insert",
            method: "POST",
            data: shippingAddress
        }).then(function(response) {
            // reset form
            $scope.shippingFullName = "";
            $scope.shippingLine1 = "";
            $scope.shippingLine2 = "";
            $scope.shippingCity = "";
            $scope.shippingState = "";
            $scope.shippingZipCode = "";
        }, function(response) {
            console.log("Errors in data you're sending");
        });
    }
});