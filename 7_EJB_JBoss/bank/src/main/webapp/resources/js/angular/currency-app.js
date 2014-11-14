var currencyApp = angular.module('CurrencyApp', []);

	currencyApp.controller('CurrencyCtrl', function ($scope, $http){

	$http.get('currency/getall').
		success(function(data) {
			$scope.currencies = data;
		}
	);
});