<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="components/header.jsp"%>

<div class="main">
    <p class="sign" align="center">Sign in</p>
    <form class="form1" action="login" method="post">
        <input class="un" type="text" align="center" placeholder="Username" name="userName">
        <input class="pass" type="password" align="center" placeholder="Password" name="password">
        <button class="submit">Sign in</button>
        <p class="forgot" align="center"><a href="#">Forgot Password?</a></p>
    </form>
    <div class="alert alert-danger" role="alert">
        <%=request.getAttribute("error-message") != null ? request.getAttribute("error-message") : ""%>
    </div>
</div>


<%@include file="components/footer.jsp"%>