<jsp:include page="header.jsp"/>

<header>
	<h1>Update Account</h1>
</header>

<div ng-app="AccountApp" ng-controller="AccountCtrl">

	<section>

		<table>

			<tr>
				<td>Bank:</td>
				<td><select ng-model="selectedBankId" ng-options="item.id as item.name for item in banks">
					<option value="">Select Bank</option>
				</select></td>
			</tr>

			<tr>
				<td>Account:</td>
				<td><select ng-model="selectedAccountId" ng-options="item.id as item.asstring for item in bankAccounts">
					<option value="">Select Account</option>
				</select></td>
			</tr>

			<tr>
				<td>Amount:</td>
				<td><input ng-model="amount"></td>
				<td><span class="invalid" ng-show="errors && errors.amount">{{errors.amount.message}}</span></td>
			</tr>

			<tr>
				<td>Currency:</td>
				<td><select ng-model="currency" ng-options="item.name as item.name for item in currencies">
					<option value="">Select Currency</option>
				</select></td>
				<td><span class="invalid" ng-show="errors && errors.currency">{{errors.currency.message}}</span></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="button" ng-click="updateAccount()" value="Update Account"></td>
			</tr>

		</table>

	</section>

</div>

<jsp:include page="footer.jsp"/>



