var accountApp = angular.module('AccountApp', []);

accountApp.controller('AccountCtrl', function ($scope, $http) {

	function populateAccounts(bankId) {

		$http.get('account/get-all-for-bank/' + bankId).
			success(function(data) {
				$scope.bankAccounts = data;
				console.log('Accounts are fetched');
			}
		);
	}

	function populateAccount(accountId) {
		var accounts = $scope.bankAccounts;
		for(var i = 0; i < accounts.length; ++i) {
			var account = accounts[i];
			if(account.id == accountId) {
				console.log('Accounts is found: ' + account.asstring);
				$scope.selectedAccount = account;
				$scope.amount = $scope.selectedAccount.amount;
				$scope.currency = $scope.selectedAccount.currency;
			}
		}
	}

	function findCurrency(currencyName) {
		var currencies = $scope.currencies;
		for(var i = 0; i < currencies.length; ++i) {
			var currency = currencies[i];
			if(currency.name == currencyName) {
				return currency;
			}
		}
		return null;
	}

	function exchangeCurrency(oldCurrency, newCurrency, amount) {

		$http.get('currency/exchange/old/' + oldCurrency + '/new/' + newCurrency + '/amount/' + amount).
			success(function(data) {
				$scope.amount = data;
				console.log('Currency is exchanged');
			}
		);
	}

	function updateBankAccount(account) {
	
		$http.post('account/update', {
			accountid: account.id,
			amount: account.amount,
			currency: account.currency
		}).
		success(function(data, status, headers) {
			console.log('Account is updated in db');
			populateAccounts(newBankId);
			populateAccount(account.id);
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
				return findCurrency(value) != null;
			},
			message: 'Select available currency'
		}
	};


	$http.get('bank/getall').
		success(function(data) {
			$scope.banks = data;
		}
	);

	$http.get('currency/getall').
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
		if(newValue) {

			if(!$scope.validators.amount.isValid($scope.amount)) {
				console.log('Amount error: ' + $scope.amount);
				$scope.errors = {};
				$scope.errors.amount = {message: $scope.validators.amount.message };
			} else if (oldValue){
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

		if($.isEmptyObject(errors)) {
			$scope.selectedAccount.amount = $scope.amount;
			$scope.selectedAccount.currency = $scope.currency;
			console.log('Account is updated: ' + $scope.selectedAccount.amount + ' (' + $scope.selectedAccount.currency + ')');
			updateBankAccount(account);
		}
	}

});