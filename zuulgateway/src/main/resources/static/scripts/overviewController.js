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
        var prices = response.data;
        prices.tax = prices.tax.toFixed(2);

        total = parseFloat(response.data.tax) + parseFloat(response.data.subTotal) + parseFloat(response.data.shipping);

        $scope.prices = prices;
        $scope.total = total.toFixed(2);
    }, function () {
        console.log("Failed to update cart price");
    });

});