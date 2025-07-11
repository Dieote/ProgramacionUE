<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="comunes/cabecero.jsp"%>

<%@ include file="comunes/navegacion.jsp"%>

    <div class="container">
        <div class="text-center" style="margin: 30px">
            <h3>Sistema de Empleados</h3>
        </div>

        <form class="row g-3 mb-4" method="get" action="${pageContext.request.contextPath}/">
            <div class="col-md-4">
                <input type="text" name="nombreEmpleado" class="form-control" placeholder="Buscar por nombre.."
                value="${nombreBuscado != null ? nombreBuscado : ''}">
            </div>
            <div class="col-md-4">
                <select name="departamento" class="form-select">
                    <option value="">-- Todos los departamentos --</option>
                    <c:forEach var="dep" items="${departamentos}">
                        <option value="${dep}" ${departamentoBuscado == dep ? 'selected' : ''}>${dep}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <button type="submit" class="btn btn-primary">Buscar</button>
                <a href="${urlLimpiar}" class="btn btn-secondary">Limpiar</a>
            </div>
        </form>

            <table class="table table-striped table-hover table-bordered align-middle">
                <thead class="table-dark text-center">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Departamento</th>
                    <th scope="col">Sueldo
                    <a href="${urlAsc}" class="btn btn-sm ${order == 'desc' ? 'btn-light' : 'btn-success'} ms-1">↑</a>
                        <a href="${urlDesc}" class="btn btn-sm ${order == 'asc' ? 'btn-light' : 'btn-success'}">↓</a>
                        </th>
                    <th scope="col">
                </tr>
                </thead>
                <tbody>
                <c:forEach var="empleado" items="${empleados}">
                    <tr>
                        <td>${empleado.idEmpleado}</td>
                        <td>${empleado.nombreEmpleado}</td>
                        <td>${empleado.departamento}</td>
                        <td>
                            <fmt:setLocale value="es_ES"/>
                            <fmt:formatNumber type="currency"
                                              value="${empleado.sueldo}"/>
                        </td>
                        <td class="text-center">
                        <c:set var="urlEditar">
                            <c:url value="${application.contextPath}/editar">
                                <c:param name="idEmpleado"
                                         value="${empleado.idEmpleado}"/>
                            </c:url>
                        </c:set>
                        <a href="${urlEditar}"
                           class="btn btn-warning btn-sm me-3">Editar</a>

                            <c:url var="urlEliminar" value="/eliminar">
                                <c:param name="idEmpleado" value="${empleado.idEmpleado}"/>
                            </c:url>
                        <a href="${urlEliminar}" onclick="return confirm('¿Estás seguro de eliminar este empleado?')"
                        class="btn btn-danger btn-sm">Eliminar</a>
                    </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

   <%@ include file="comunes/pie-pagina.jsp"%>