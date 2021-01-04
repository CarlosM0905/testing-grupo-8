<%-- 
    Document   : supraeventos-proximos
    Created on : Nov 1, 2019, 4:59:35 PM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-participante-template title="Eventos próximos">
    <jsp:attribute name="content">
        
        <c:if test="${exito != null && exito.length() > 0}">
            <div class="alert alert-success" role="alert">
                ${exito}
            </div>
        </c:if>
                    
        <h2>Eventos próximos</h2>
        <div class="row">
            <c:choose>
                <c:when test="${supraeventos_proximos!=null && supraeventos_proximos.size() > 0}">
                    <c:forEach var="supraevento_proximo" items="${supraeventos_proximos}" >
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card 
                                <c:choose>
                                    <c:when test="${supraevento_proximo.estaDisponible()}">
                                        border-bottom-success
                                    </c:when>
                                    <c:when test="${supraevento_proximo.estaLleno()}">
                                        border-bottom-secondary
                                    </c:when>
                                    <c:when test="${supraevento_proximo.estaEnProceso()}">
                                        border-bottom-warning
                                    </c:when>
                                    <c:when test="${supraevento_proximo.estaFinalizado()}">
                                        border-bottom-danger
                                    </c:when>    
                                </c:choose>">
                                <summary class="abrir-detalles-supraevento" data-toggle="modal" 
                                         data-target="#modalDetallesSupraevento"
                                         data-id="${supraevento_proximo.idSupraevento}">
                                    <img class="card-img-top" src="${pageContext.request.contextPath}/img/event.jpg" alt="Imagen de evento.png">
                                    <div class="card-block px-3 pb-3">
                                        <h4 class="card-title mt-3">${supraevento_proximo.nombreSupraevento}</h4>
                                        <div class="card-text">
                                            <strong>Fecha inicio:</strong> ${supraevento_proximo.fechaInicio} <br>
                                            <strong>Fecha de fin:</strong> ${supraevento_proximo.fechaFin} <br>
                                            <strong>Entradas disponibles:</strong> ${supraevento_proximo.entradasDisponibles - supraevento_proximo.numeroInscritos} <br>
                                        </div>
                                    </div>
                                </summary>
                                <div class="card-footer" style="text-align: center">
                                    <c:choose>
                                        <c:when test="${supraevento_proximo.estaDisponible()}">
                                            <strong class="align-middle text-success">Evento disponible</strong>
                                        </c:when>
                                        <c:when test="${supraevento_proximo.estaLleno()}">
                                            <strong class="align-middle text-secondary">Sin aforo</strong>
                                        </c:when>
                                        <c:when test="${supraevento_proximo.estaEnProceso()}">
                                            <strong class="align-middle text-warning">En proceso</strong>
                                        </c:when>
                                        <c:when test="${supraevento_proximo.estaFinalizado()}">
                                            <strong class="align-middle text-danger">Finalizado</strong>
                                        </c:when>
                                        <c:otherwise>
                                            <strong class="align-middle">${evento_proximo.estadoEvento}</strong>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p><strong>No hay eventos disponibles</strong></p>    
                </c:otherwise>
            </c:choose>
        </div>
        
        <%@ include file="detalles.jsp" %> 
        
    </jsp:attribute>
</mt:basic-participante-template>
