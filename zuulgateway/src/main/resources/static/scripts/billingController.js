angular.module("MainApp").controller('BillingController', function ($http, $scope, $log) {

    $log.debug('Starting Billing Controller');

    // Make fake cusomter for presentation
    $scope.customer = {
        id: 7
    };

    $http({
        url: "http://localhost:8723/shopping/billing/address/byId/" +$scope.customer.id ,
        method: "GET"
    }).then(function(response) {
        //TODO map fetch stuff
        $log.debug(response.data)
    }, function(response) {
        console.log("GET ALL: Failed to fetch addresses");
    });

    $http({
        url: "http://localhost:8723/shopping/billing/creditCard/byId/" +$scope.customer.id ,
        method: "GET"
    }).then(function(response) {
        //TODO map fetch stuff
        $log.debug(response.data)
    }, function(response) {
        console.log("GET ALL: Failed to fetch credit card");
    });

    $scope.sendShipping = function() {
        $log.debug('in send shipping');
        var shippingAddress = {
            customerId:     $scope.customer.id,
            fullName:       $scope.shippingFullName,
            line1:          $scope.shippingLine1,
            line2:          $scope.shippingLine2,
            city:           $scope.shippingCity,
            state:          $scope.shippingState,
            zipCode:        $scope.shippingZipCode,
            billing:        false
        };

        $http({
            url:"http://localhost:8723/shopping/billing/address/insert",
            method: "POST",
            data: shippingAddress
        }).then(function(response) {
            $log.debug(response.data);
            // reset form
            $scope.shippingFullName = "";
            $scope.shippingLine1    = "";
            $scope.shippingLine2    = "";
            $scope.shippingCity     = "";
            $scope.shippingState    = "";
            $scope.shippingZipCode  = "";
        }, function(response) {
            console.log("Errors in data you're sending");
        });
    }

    $scope.sendBilling = function () {
        var billingAddress = {
            customerId: $scope.customer.id,
            fullName:   $scope.billingFullName,
            line1:      $scope.billingLine1,
            line2:      $scope.billingLine2,
            city:       $scope.billingCity,
            state:      $scope.billingState,
            zipCode:    $scope.billingZipCode,
            billing:    true
        };

        $http({
            url:"http://localhost:8723/shopping/billing/address/insert",
            method: "POST",
            data: billingAddress
        }).then(function(response) {
            $log.debug(response.data);
            // reset form
            $scope.billingFullName  = "";
            $scope.billingLine1     = "";
            $scope.billingLine2     = "";
            $scope.billingCity      = "";
            $scope.billingState     = "";
            $scope.billingZipCode   = "";
        }, function(response) {
            console.log("Errors in data you're sending");
        });
    }

    $scope.sendCard = function () {
        var card = {
            customerId: $scope.customer.id,
            fullName:   $scope.fullName,
            number:     $scope.number,
            expDate:    $scope.expYear + $scope.expMonth,
            validate:   $scope.validate
        };
        
        $log.debug(card.expDate);

        $http({
            url:"http://localhost:8723/shopping/billing/creditCard/insert",
            method: "POST",
            data: card
        }).then(function(response) {
            $log.debug(response.data);
            // reset form
            $scope.fullName = "";
            $scope.number   = "";
            $scope.expYear  = "";
            $scope.expMonth = "";
            $scope.validate = "";
        }, function(response) {
            console.log("Errors in data you're sending");
        });
    }
});