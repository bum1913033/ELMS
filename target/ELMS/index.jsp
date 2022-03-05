<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="components/header.jsp"%>

<c:if test="${firstName!=null}">
    <c:redirect url="/employee" />
</c:if>

<div class="main">
    <p class="sign" align="center">Sign in</p>
    <form class="form1" action="login" method="post">
        <input class="un" type="text" align="center" placeholder="Username" name="userName">
        <input class="pass" type="password" align="center" placeholder="Password" name="password">
        <button class="submit">Sign in</button>
        <p class="forgot" align="center"><a href="#">Forgot Password?</a></p>
    </form>
    <span>
        <%=request.getAttribute("error-message") != null ? request.getAttribute("error-message") : ""%>
    </span>
</div>

<%--class="alert alert-danger" role="alert"--%>

<%@include file="components/footer.jsp"%>