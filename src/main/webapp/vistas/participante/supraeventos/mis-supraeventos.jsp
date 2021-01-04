<%-- 
    Document   : mis-supraeventos
    Created on : Nov 2, 2019, 9:47:05 AM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-participante-template title="Mis eventos">
    <jsp:attribute name="content">
        <h3>Mis eventos próximos</h3>
        <table class="table table-hover">
            <tbody>
                <c:forEach var="supraevento" items="${supraeventos}">
                    <tr class="row">
                        <td class="col-sm-2 align-middle">${supraevento.fechaInicio}</td>
                        <td class="col-sm-2 align-middle">${supraevento.fechaFin}</td>
                        <th class="col-sm-4 align-middle">${supraevento.nombreSupraevento}</th>
                        <td class="col-sm-1">
                            <a class="btn btn-secondary abrir-detalles-supraevento text-white" 
                               data-toggle="modal" 
                               data-target="#modalDetallesSupraevento"
                               data-id="${supraevento.idSupraevento}" href="#">Info</a>
                        </td>
                        <td class="col-sm-3">
                            <c:if test="${!supraevento.estaEnProceso()}">
                               <a class="btn btn-danger btn-cancelar-inscripcion text-white" 
                               data-toggle="modal" data-target="#cancelar_inscripcion_modal"
                               data-supraevento-nombre="${supraevento.nombreSupraevento}"
                               data-id="${supraevento.idSupraevento}" href="#">Cancelar inscripcion</a>
                            </c:if>
                            <c:if test="${supraevento.estaEnProceso()}">
                                <p>El evento se está llevando a cabo</p>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
          </table>
        
        <%@ include file="detalles.jsp" %> 
        <%@ include file="cancelar-inscripcion.jsp" %> 
    </jsp:attribute>
</mt:basic-participante-template>
