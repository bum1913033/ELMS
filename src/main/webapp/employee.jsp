<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="components/header.jsp"%>

<c:if test="${firstName==null}">
    <c:redirect url="/login" />
</c:if>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <span class="navbar-brand mb-0 h1">ELMS</span>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav ms-auto">

                <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/employee-save">
                    Add  <i class="fas fa-plus" style="color: white"></i>
                </a>

                <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/logout">
                    Logout <i class="far fa-sign-out"></i>
                </a>

            </div>
        </div>
    </div>
</nav>

<div class="table-responsive list-table">
    <div class="w-100 text-center">
        <p class="emp-text">Employee Table</p>
    </div>
    <table class="table table-hover">
        <thead class="table-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Faculty</th>
            <th scope="col">Remaining Leaves</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.firstName}"/></td>
                <td><c:out value="${employee.lastName}"/></td>
                <td><c:out value="${employee.faculty}"/></td>
                <td><c:out value="${employee.absence}"/></td>
                <td>
                    <a class="btn btn-edit"
                       href="${pageContext.request.contextPath}/employee-save?id=<c:out value="${employee.id}"/>">Edit</a>
                    <a class="btn btn-danger"
                       href="${pageContext.request.contextPath}/employee?id=<c:out value="${employee.id}"/>">
                        <i class="far fa-trash-alt"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>

        </tbody>

    </table>
</div>

<%@ include file="components/footer.jsp"%>