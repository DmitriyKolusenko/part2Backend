<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>TS Shop!</h2>
<form action='<spring:url value="/loginAction"/>' content="application/json" method="post">
    <table>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><button type="submit">Login</button></td>
        </tr>
    </table>
</form>
<a href='<spring:url value="/logout"/>'>Logout</a>
</body>
</html>