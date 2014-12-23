<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
	<meta charset="utf-8">
	<title><tiles:getAsString name="title" /></title>

	<script type="text/javascript" src="/BankApp/resources/lib/angular-1.2.1/angular.min.js"></script>
	<script type="text/javascript" src="/BankApp/resources/lib/jquery-2.0.3/jquery-2.0.3.min.js"></script>

	<script type="text/javascript" src="/BankApp/resources/js/angular/currency-app.js"></script>
	<script type="text/javascript" src="/BankApp/resources/js/angular/account-app.js"></script>

	<link rel="stylesheet" type="text/css" href="/BankApp/resources/css/app.css">
</head>
<body>
	<div id="header">
		<div id="headerTitle"><tiles:insertAttribute name="header" /></div>
	</div>
	<div id="menu">
		<tiles:insertAttribute name="menu" />
	</div>
	<div id="content">
		<td><tiles:insertAttribute name="body" />
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>