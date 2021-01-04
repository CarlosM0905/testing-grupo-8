<%-- 
    Document   : mis-eventos
    Created on : Oct 11, 2019, 1:26:54 PM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-participante-template title="Mis eventos">
    <jsp:attribute name="content">
        <h3>Mis eventos</h3>
        <table class="table table-hover">
            <tbody>
                <c:forEach var="evento" items="${eventos}">
                    <tr class="row">
                        <td class="col-sm-2 align-middle">${evento.fechaEvento}</td>
                        <th class="col-sm-6 align-middle">${evento.nombreEvento}</th>
                        <td class="col-sm-1">
                            <a class="btn btn-secondary abrir-detalles-evento text-white" 
                               data-toggle="modal" 
                               data-target="#modalDetallesEvento"
                               data-id="${evento.idEvento}" href="#">Info</a>
                        </td>
                        <td class="col-sm-3">
                            <a class="btn btn-danger btn-cancelar-inscripcion text-white" 
                               data-toggle="modal" data-target="#cancelar_inscripcion_modal"
                               data-evento-nombre="${evento.nombreEvento}"
                               data-id="${evento.idEvento}" href="#">Cancelar inscripcion</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
          </table>
        
        <%@ include file="detalles.jsp" %> 
        <%@ include file="cancelar-inscripcion.jsp" %> 
    </jsp:attribute>
</mt:basic-participante-template>
