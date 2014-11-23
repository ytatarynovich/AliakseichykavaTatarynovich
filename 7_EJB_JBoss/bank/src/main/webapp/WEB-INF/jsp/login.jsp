<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/>

    <h3>Order WareHouse Dashboard</h3>
    <h2>Please insert your credentials.</h2>

    <c:if test="${not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION']}">
        <div class="errorblock">
            Your login attempt was not successful, try again.<br /> Caused :
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>

 
    <form name='f' action="j_spring_security_check"
        method='POST'>
 
        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='j_username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='j_password' /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="Send" /></td>
            </tr>
        </table>
 
    </form>

<jsp:include page="footer.jsp"/>