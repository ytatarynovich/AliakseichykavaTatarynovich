<jsp:include page="header.jsp"/>

<header>
	<h1>All Currencies</h1>
</header>

<div ng-app="CurrencyApp" ng-controller="CurrencyCtrl">

	<table>
		<tr ng-repeat="currency in currencies">
			<td>{{ currency.name }}</td>
			<td>{{ currency.rate }}</td>
		</tr>
	</table>

</div>

<jsp:include page="footer.jsp"/>