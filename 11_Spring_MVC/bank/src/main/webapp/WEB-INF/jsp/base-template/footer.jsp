<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<footer>
	&nbsp;

	<c:if test="${not empty pageContext.request.userPrincipal}">

		<b>UserName</b>: ${pageContext.request.userPrincipal.name}

		&nbsp;

		<form action="/BankApp/j_spring_security_logout" method="post" id="logoutForm">
			<input name="submit" type="submit" value="Logout" />
		</form>

	</c:if>

</footer>