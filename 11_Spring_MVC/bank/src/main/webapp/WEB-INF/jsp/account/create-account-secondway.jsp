<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<header>
	<h1>Create Account (Spring MVC)</h1>
</header>

<form:form method="POST" commandName="accountDto" action="createAccount.do">
	<form:errors path="*" cssClass="errorblock" element="div" />
	<table>
		<tr>
			<td>Bank:</td>
			<td>
				<form:select path="bankId">
					<form:option value="" label="--- Select ---"/>
					<form:options items="${banks}" />
				</form:select>
			</td>
			<td><form:errors path="bankId" cssClass="error" /></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><form:input path="firstName" /></td>
			<td><form:errors path="firstName" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><form:input path="lastName" /></td>
			<td><form:errors path="lastName" cssClass="error" /></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Create Account" /></td>
		</tr>
	</table>
</form:form>