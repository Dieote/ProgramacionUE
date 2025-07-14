<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="comunes/cabecero.jsp" %>
<%@ include file="comunes/navegacion.jsp" %>

<div class="container mt-5">
    <h3 class="text-center mb-4">Estadísticas de Empleados</h3>

    <div class="row mb-4">
        <div class="col-md-4">
            <div class="card text-bg-primary">
                <div class="card-body text-center">
                    <h5 class="card-title">Promedio de Sueldos</h5>
                    <p class="card-text fs-4">
                        <fmt:formatNumber value="${promedioSueldos}" type="currency" />
                    </p>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card text-bg-success">
                <div class="card-body text-center">
                    <h5 class="card-title">Total de Departamentos</h5>
                    <p class="card-text fs-4">${cantidadDepartamentos}</p>
                </div>
            </div>
        </div>
    </div>

    <h5>Empleados por Departamento</h5>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>Departamento</th>
                <th>Cantidad de Empleados</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entry" items="${empleadosPorDepartamento}">
                <tr>
                    <td>${entry.key}</td>
                    <td>${entry.value}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="comunes/pie-pagina.jsp" %>
