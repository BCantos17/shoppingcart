angular.module("MainApp").controller('OverviewController', function($http, $scope, $log, billingService, cartService){

    $scope.customer = {
        id: 7
    };

    $scope.invoice = {
        customerId: $scope.customer.id,
        address: billingService.getAddress(),
        card: billingService.getCard(),
        itemList: cartService.getItemList()
    };

    $scope.itemList = $scope.invoice.itemList;

});