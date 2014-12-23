<header>
	<h1>Add Account</h1>
</header>

<div ng-app="AccountApp" ng-controller="AccountCtrl">

	<div class="invalid" ng-show="errorMessage">
		{{errorMessage}}
	</div>

	<div class="message" ng-show="message">
		{{message}}
	</div>

	<section>

		<table>

			<tr>
				<td>Bank:</td>
				<td><select ng-model="selectedBankId" ng-options="item.id as item.name for item in banks">
					<option value="">--- Select Bank ---</option>
				</select></td>
				<td><span class="invalid" ng-show="errors && errors.selectedBankId">{{errors.selectedBankId.message}}</span></td>
			</tr>

			<tr>
				<td>First Name:</td>
				<td><input ng-model="firstName"></td>
				<td><span class="invalid" ng-show="errors && errors.firstName">{{errors.firstName.message}}</span></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><input ng-model="lastName"></td>
				<td><span class="invalid" ng-show="errors && errors.lastName">{{errors.lastName.message}}</span></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="button" ng-click="createAccount()" value="Create Account"></td>
			</tr>

		</table>

	</section>

</div>