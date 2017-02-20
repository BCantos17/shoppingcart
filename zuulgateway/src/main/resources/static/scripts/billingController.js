angular.module("MainApp").service('billingService', function() {
    var address;
    var card;

    var setAddress = function( pickedAddress ) { address = pickedAddress;};
    var setCard = function( pickedCard ) { card = pickedCard;};

    var getAddress = function(){return address;};
    var getCard = function () {return card;};

    return {
        setAddress: setAddress,
        setCard:    setCard,
        getAddress: getAddress,
        getCard:    getCard
    };
});

angular.module("MainApp").controller('BillingController', function ($http, $scope, $log, billingService) {

    /**
     *For Billing Service
     */
    $scope.insertAddress = function(address) {
        billingService.setAddress(address)
    };
    $scope.insertCard = function(card) {
        billingService.setCard(card)
    };

    $log.debug('Starting Billing Controller');

    // Make fake customer for presentation
    $scope.customer = {
        id: 7
    };

    var addresses           = [];
    var shippingAddresses   = [];
    var billingAddresses    = [];
    var cards               = [];

    /**
     * Get address by Customer Id
     */
    $http({
        url: "http://localhost:8723/shopping/billing/address/byId/" +$scope.customer.id ,
        method: "GET"
    }).then(function(response) {
        addresses = response.data;

        for( var i = 0; i < addresses.length; i++ ){
            if(addresses[i].billing === false )
                shippingAddresses.push(addresses[i]);
            else
                billingAddresses.push(addresses[i]);
        }

        $scope.shippingAddresses = shippingAddresses;
        $scope.billingAddresses  = billingAddresses;
    }, function(response) {
        console.log("GET ALL: Failed to fetch addresses");
    });

    /**
     * Get credit card by Customer Id
     */
    $http({
        url: "http://localhost:8723/shopping/billing/creditCard/byId/" +$scope.customer.id ,
        method: "GET"
    }).then(function(response) {
        cards = response.data
        $scope.cards = cards;
    }, function(response) {
        console.log("GET ALL: Failed to fetch credit card");
    });

    /**
     * Add new shipping Address
     */
    $scope.sendShipping = function() {
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
            // To add new address in the list dynamically
            if(response.data.billing === false )
                $scope.addShippingAddresses.push(response.data);
            else
                $scope.addBillingAddresses.push(response.data);
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
    };

    $scope.addShippingAddresses = [];
    $scope.addBillingAddresses  = [];

    /**
     * Add new billing Address
     */
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
            // To add new address in the list dynamically
            if(response.data.billing === false )
                $scope.addShippingAddresses.push(response.data);
            else
                $scope.addBillingAddresses.push(response.data);
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
    };

    $scope.addCard = [];

    /**
     * Add new credit card
     */
    $scope.sendCard = function () {
        var card = {
            customerId: $scope.customer.id,
            fullName:   $scope.fullName,
            number:     $scope.number,
            expDate:    $scope.expYear + $scope.expMonth,
            validate:   $scope.validate
        };
        
        $http({
            url:"http://localhost:8723/shopping/billing/creditCard/insert",
            method: "POST",
            data: card
        }).then(function(response) {
            // To add new card in the list dynamically
            $scope.addCard.push(response.data);
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