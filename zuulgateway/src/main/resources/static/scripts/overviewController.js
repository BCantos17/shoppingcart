angular.module("MainApp").controller('OverviewController', function($http, $scope, $log, billingService, cartService){

    $scope.customer = {
        id: 7
    };

    $scope.invoice = {
        customerId: $scope.customer.id,
        address: billingService.getAddress(),
        card: billingService.getCard(),
        itemList: cartService.getItemList()
    }

    //$scope.invoice.customerId = 7;
/*
    $scope.customer.id;*/
    $log.debug($scope.invoice.itemList);
    $log.debug($scope.customer.id);
    $log.debug(billingService.getAddress());

});