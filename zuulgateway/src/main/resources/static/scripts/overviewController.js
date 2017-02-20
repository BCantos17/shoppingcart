angular.module("MainApp").controller('OverviewController', function($http, $scope, $log, billingService){

    $scope.customer = {
        id: 7
    };

    $scope.invoice = {
        customerId: $scope.customer.id,
        address: billingService.getAddress(),
        card: billingService.getCard()
    }

    //$scope.invoice.customerId = 7;
/*
    $scope.customer.id;*/

    $log.debug($scope.customer.id);
    $log.debug(billingService.getAddress());

});