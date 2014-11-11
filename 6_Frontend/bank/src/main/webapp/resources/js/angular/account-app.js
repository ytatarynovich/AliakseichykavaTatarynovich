var accountApp = angular.module('AccountApp', []);

accountApp.controller('AccountCtrl', function ($scope, $http) {

	$scope.minEmailLength = 3;

	//dummy

	$scope.banks = [
		{id: 1, name: "The First"},
		{id: 2, name: "The Second"},
		{id: 3, name: "The Third"}
	];

	$scope.accounts = [
		{id: 1, name: "Account 1", email: "account1@mail.ru", bank: 1},
		{id: 2, name: "Account 2", email: "account2@mail.ru", bank: 1},

		{id: 3, name: "Account 3", email: "account3@mail.ru", bank: 2}
	];

	//dummy
	function findAccounts(bankId) {
		var result = [];
		for(var i = 0; i < $scope.accounts.length; ++i) {
			var account = $scope.accounts[i];
			if(account.bank == bankId) {
				result.push(account);
			}
		}
		return result;
	}

	function findAccount(accountId) {
		for(var i = 0; i < $scope.accounts.length; ++i) {
			var account = $scope.accounts[i];
			if(account.id == accountId) {
				return account;
			}
		}
		return null;
	}

	$scope.$watch('selectedBankId', function(newValue, oldValue) {
		if(newValue) {
			$scope.bankAccounts = findAccounts(newValue);
		}
	});

	$scope.$watch('selectedAccountId', function(newValue, oldValue) {
		if(newValue) {
			$scope.selectedAccount = findAccount(newValue);
			$scope.email = $scope.selectedAccount.email;
		}
	});

	$scope.updateEmail = function() {
		if($scope.email && $scope.email.length >= $scope.minEmailLength) {
			$scope.selectedAccount.email = $scope.email;
			console.log('Email is changed: ' + $scope.selectedAccount.id + ' - ' + $scope.selectedAccount.email);
		} else {
			var errors = {};
			errors.emailInvalid = true;
			$scope.errors = errors;
			console.log('App error');
		}
	}

});