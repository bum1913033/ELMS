<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../components/header.jsp"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <span class="navbar-brand mb-0 h1">ELMS</span>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav ms-auto">

                <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/employee">
                    cancel <i class="fal fa-window-close"></i>
                </a>

            </div>
        </div>
    </div>
</nav>

<div class="container form-container">
    <form action="${pageContext.request.contextPath}/employee-save" method="POST">
        <div class="row">
            <div class="col-25">
                <label for="firstName">First Name: </label>
            </div>
            <div class="col-75">
                <input id="firstName" name="firstName" required type="text"
                       value="<c:out value='${employee.firstName}'/>"/>
            </div>
        </div>

        <div class=" row">
            <div class="col-25">
                <label for="lastName">Last Name: </label>
            </div>
            <div class="col-75">
                <input id="lastName" name="lastName" required type="text" value="<c:out value='${employee.lastName}'/>"/>
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="faculty">faculty: </label>
            </div>
            <div class="col-75">
                <input id="faculty" name="faculty" required type="text" value="<c:out value='${employee.faculty}'/>"/>
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="absence">Absence: </label>
            </div>
            <div class="col-75">
                <input id="absence" name="absence" required type="text"
                       value="<c:out value='${employee.absence}'/>"/>
            </div>
        </div>

        <input type="hidden" name="id" id="id" value="<c:out value='${employee.id}' />"/>

        <div class="row">
            <div class="col-75">
                <input type="submit" value="<%=request.getAttribute("action")%>">
            </div>
        </div>

    </form>
</div>

<%@ include file="../components/footer.jsp"%>