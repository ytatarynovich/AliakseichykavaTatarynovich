var accountApp = angular.module('AccountApp', []);

accountApp.controller('AccountCtrl', ['$scope', '$http', 'accountsService', function ($scope, $http, accountsService) {

	function populateAccounts(bankId) {

		$http.get('/BankApp/account/get-all-for-bank/' + bankId).
			success(function(data) {
				$scope.bankAccounts = data;
				console.log('Accounts are fetched');
				if($scope.selectedAccountId) {
					populateAccount($scope.selectedAccountId);
				}
			}
		);
	}

	function populateAccount(accountId) {
		var accounts = $scope.bankAccounts;
		var account = accountsService.findAccount(accountId, accounts);
		if(account) {
			console.log('Accounts is found: ' + account.asstring);
			$scope.selectedAccount = account;
			$scope.currency = $scope.selectedAccount.currency;
			$scope.amount = $scope.selectedAccount.amount;
		}
	}

	function exchangeCurrency(oldCurrency, newCurrency, amount) {

		$http.get('/BankApp/currency/exchange/old/' + oldCurrency + '/new/' + newCurrency + '/amount/' + amount).
			success(function(data) {
				$scope.amount = data;
				console.log('Currency is exchanged');
			}
		);
	}

	function updateBankAccount(account) {

		$http.post('/BankApp/account/update/' + account.id + '/' + account.currency + '/' + account.amount).
		success(function(data, status, headers) {
			console.log('Account is updated in db');
			populateAccounts($scope.selectedBankId);
		});

	}

	function isNumber(n) {
		return !isNaN(parseFloat(n)) && isFinite(n);
	};

	$scope.validators = {

		amount: {
			isValid: function(value) {
				return isNumber(value) && parseFloat(value) > 0;
			},
			message: 'Amount should be a positive number'
		},

		currency: {
			isValid: function(value) {
				return accountsService.findCurrency(value, $scope.currencies) != null;
			},
			message: 'Select available currency'
		}
	};


	$http.get('/BankApp/bank/getall').
		success(function(data) {
			$scope.banks = data;
		}
	);

	$http.get('/BankApp/currency/getall').
		success(function(data) {
			$scope.currencies = data;
		}
	);

	$scope.$watch('selectedBankId', function(newBankId, oldValue) {
		if(newBankId) {
			populateAccounts(newBankId);
		}
	});

	$scope.$watch('selectedAccountId', function(newValue, oldValue) {
		if(newValue) {
			populateAccount(newValue);
		}
	});

	$scope.$watch('currency', function(newValue, oldValue) {
		if(newValue && oldValue) {

			if(!$scope.validators.amount.isValid($scope.amount)) {
				console.log('Amount error: ' + $scope.amount);
				$scope.errors = {};
				$scope.errors.amount = {message: $scope.validators.amount.message };
			} else {
				exchangeCurrency(oldValue, newValue, $scope.amount);
			}
		}
	});


	$scope.updateAccount = function() {

		$scope.errors = {};

		if(!$scope.validators.amount.isValid($scope.amount)) {
			console.log('Amount error: ' + $scope.amount);
			$scope.errors.amount = {message: $scope.validators.amount.message };
		}

		if(!$scope.validators.currency.isValid($scope.currency)) {
			console.log('Currency error: ' + $scope.currency);
			$scope.errors.currency = {message: $scope.validators.currency.message };
		} 

		if($.isEmptyObject($scope.errors)) {
			$scope.selectedAccount.amount = $scope.amount;
			$scope.selectedAccount.currency = $scope.currency;
			console.log('Account is updated: ' + $scope.selectedAccount.amount + ' (' + $scope.selectedAccount.currency + ')');
			updateBankAccount($scope.selectedAccount);
		}
	}

}]);


accountApp.factory('accountsService', function() {

	var newScope = {};

	newScope.findAccount = function(accountId, accounts) {
		for(var i = 0; i < accounts.length; ++i) {
			var account = accounts[i];
			if(account.id == accountId) {
				return account;
			}
		}
		return null;
	}

	newScope.findCurrency = function(currencyName, currencies) {
		for(var i = 0; i < currencies.length; ++i) {
			var currency = currencies[i];
			if(currency.name == currencyName) {
				return currency;
			}
		}
		return null;
	}

	return newScope;
});