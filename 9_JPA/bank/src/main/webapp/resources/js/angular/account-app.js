var accountApp = angular.module('AccountApp', []);

accountApp.controller('AccountCtrl', ['$scope', '$http', '$timeout', 'accountsService', function ($scope, $http, $timeout, accountsService) {

	$scope.message = '';
	$scope.errorMessage = '';

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

		$scope.message = '';

		var accounts = $scope.bankAccounts;
		var account = accountsService.findAccount(accountId, accounts);
		if(account) {
			console.log('Accounts is found: ' + account.asstring);
			$scope.currency = account.currency;
			$scope.amount = account.amount;
		}
	}

	/*function exchangeCurrency(oldCurrency, newCurrency, amount) {

		$http.get('/BankApp/currency/exchange/old/' + oldCurrency + '/new/' + newCurrency + '/amount/' + amount).
			success(function(data) {
				$scope.amount = data;
				console.log('Currency is exchanged');
			}
		);
	}*/

	function updateBankAccount(accountId, amount, currency) {

		$scope.message = '';
		$scope.errorMessage = '';

		$http.post('/BankApp/account/update/' + accountId + '/' + currency + '/' + amount).
		success(function(data, status, headers) {
			console.log('Account is updated in db');
			populateAccounts($scope.selectedBankId);

			$timeout(function() { $scope.message = 'Account ' + account.id + ' has been updated'; }, 100);
		}).error(function(data, status, headers, config) {
			console.log(data);
			$scope.errorMessage = 'Account has not been updated';
		});
	}

	function createBankAccount(bankId, firstName, lastName) {

		$scope.message = '';
		$scope.errorMessage = '';

		$http.get('/BankApp/account/create/' + bankId + '/' + firstName + '/' + lastName).
		success(function(data, status, headers) {
			console.log('Account with id [' + data + '] is created');
			$scope.message = 'Account [' + data + '] has been created';
		}).error(function(data, status, headers, config) {
			console.log(data);
			$scope.errorMessage = 'Account has not been created';
		});
	}

	function isNumber(n) {
		return !isNaN(parseFloat(n)) && isFinite(n);
	};

	var MIN_NAME_LENGTH = 2;
	var MAX_NAME_LENGTH = 30;

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
		},

		name: {
			isValid: function(value) {
				return value && value.length >= MIN_NAME_LENGTH && value.length <= MAX_NAME_LENGTH;
			},
			message: 'Name length should be from [' + MIN_NAME_LENGTH + '] to [' + MAX_NAME_LENGTH + '] letters'
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

	/*$scope.$watch('currency', function(newValue, oldValue) {
		if(newValue && oldValue) {

			if(!$scope.validators.amount.isValid($scope.amount)) {
				console.log('Amount error: ' + $scope.amount);
				$scope.errors = {};
				$scope.errors.amount = {message: $scope.validators.amount.message };
			} else {
				exchangeCurrency(oldValue, newValue, $scope.amount);
			}
		}
	});*/


	$scope.updateAccount = function() {

		$scope.errors = {};

		if(!$scope.selectedAccountId) {
			$scope.errors.selectedAccount = {message: 'Select Account'};
		}

		if(!$scope.validators.amount.isValid($scope.amount)) {
			console.log('Amount error: ' + $scope.amount);
			$scope.errors.amount = {message: $scope.validators.amount.message};
		}

		if(!$scope.validators.currency.isValid($scope.currency)) {
			console.log('Currency error: ' + $scope.currency);
			$scope.errors.currency = {message: $scope.validators.currency.message};
		} 

		if($.isEmptyObject($scope.errors)) {
			console.log('Account is updated: ' + $scope.amount + ' (' + $scope.currency + ')');
			updateBankAccount($scope.selectedAccountId, $scope.amount, $scope.currency);
		}
	};

	$scope.createAccount = function() {

		$scope.errors = {};

		if(!$scope.selectedBankId) {
			$scope.errors.selectedBankId = {message: 'Select Bank'};
		}

		if(!$scope.validators.name.isValid($scope.firstName)) {
			console.log('First Name error: ' + $scope.firstName);
			$scope.errors.firstName = {message: $scope.validators.name.message};
		}

		if(!$scope.validators.name.isValid($scope.lastName)) {
			console.log('Last Name error: ' + $scope.lastName);
			$scope.errors.lastName = {message: $scope.validators.name.message};
		}

		if($.isEmptyObject($scope.errors)) {
			console.log('Add account...');
			createBankAccount($scope.selectedBankId, $scope.firstName, $scope.lastName);
		}
	};

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