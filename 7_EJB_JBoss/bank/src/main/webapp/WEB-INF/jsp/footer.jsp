<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<footer>

	<c:if test="${not empty user}">
		<b>UserName</b>: ${user.login}<br>
		<a href="/j_spring_security_logout" > Logout</a>
	</c:if>

</footer>

</body>
</html>