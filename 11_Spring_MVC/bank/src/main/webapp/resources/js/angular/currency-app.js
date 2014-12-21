var currencyApp = angular.module('CurrencyApp', []);

currencyApp.controller('CurrencyCtrl', function ($scope, $http, $cacheFactory) {

	var currenciesCache = $cacheFactory('currenciesCache', {
		maxAge: 60 * 60 * 1000,
		deleteOnExpire: 'aggressive',
		onExpire: function (key, value) {
			$http.get(key)
			.success(function (data) {
				currenciesCache.put(key, data);
			});
		}
	});

	var allCurrenciesUrl = '/BankApp/currency/getall';

	$http.get(allCurrenciesUrl).
		success(function(data) {
			currenciesCache.put(allCurrenciesUrl, data);
		}
	);

	$scope.getCurrencies = function() {
		return currenciesCache.get(allCurrenciesUrl);
	};

});