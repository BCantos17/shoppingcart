angular.module("MainApp").controller('OverviewController', function($http, $scope, $log, billingService, cartService){

    var cartId = "1";

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


    $http({
        url: "/shopping/price/updateCartPrice/" + cartId,
        method: "PUT"
    }).then(function (response) {
        alert("success");
        $scope.prices = response.data;
        $scope.total = response.data.tax + response.data.subTotal;
    }, function () {
        console.log("Failed to update cart price");
    });

});