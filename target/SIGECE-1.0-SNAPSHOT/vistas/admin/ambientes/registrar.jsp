<%-- 
    Document   : registrar
    Created on : Oct 2, 2019, 12:07:55 PM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-admin-template title="Registrar ambiente">
    <jsp:attribute name="content">
        <form method="POST" action="${pageContext.request.contextPath}/admin/ambientes/registrar">
            <div class="form-group"> <!-- Full Name -->
                <label for="nombre_ambiente" class="control-label">Nombre ambiente</label>
                <input type="text" class="form-control" id="nombre_ambiente" name="nombre_ambiente" required
                       pattern="[a-zA-ZÀ-ÿ\u00f1\u00d1][ a-zA-Z0-9À-ÿ\u00f1\u00d1]*" title="Ingrese un nombre de ambiente válido. Ejm: Labo 1"/>
            </div>	

            <div class="form-group">
                <label for="capacidad_ambiente" class="control-label">Capacidad del ambiente</label>
                <input type='text' class="form-control" name="capacidad_ambiente"
                       pattern="[1-9][0-9]{1,2}" title="El campo solo acepta dígitos. El campo debe ser como mínimo 10 y menor a 1000" required/>
            </div>
            
            <c:if test="${error != null && error.length() > 0}">
                <div class="alert alert-danger" role="alert">
                    ${error}
                </div>
            </c:if>
            
            <div class="form-group"> <!-- Submit Button -->
                <a href="${pageContext.request.contextPath}/admin/ambientes" class="btn btn-secondary">Cancelar</a>
                <button type="submit" class="btn btn-primary">Registrar</button>
            </div> 
        </form>
    </jsp:attribute>
</mt:basic-admin-template>
