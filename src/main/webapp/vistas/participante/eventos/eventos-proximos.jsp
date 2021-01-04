<%-- 
    Document   : eventos-proximos
    Created on : Oct 11, 2019, 1:26:39 PM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-participante-template title="Eventos próximos">
    <jsp:attribute name="content">
        <h2>Eventos de hoy: <strong>${hoy}</strong></h2>
        <div class="row">
            <c:choose>
                <c:when test="${eventos_de_hoy!=null && eventos_de_hoy.size()>0}">
                    <c:forEach var="evento_de_hoy" items="${eventos_de_hoy}" >
                        <div class="col-xl-3 col-md-6 mb-4">    
                            <div class="card
                                 <c:choose>
                                     <c:when test="${evento_de_hoy.estaDisponible()}">
                                         border-bottom-success
                                     </c:when>
                                     <c:when test="${evento_de_hoy.estaFinalizado()}">
                                         border-bottom-danger
                                     </c:when>
                                     <c:when test="${evento_de_hoy.estaEnProceso()}">
                                         border-bottom-warning
                                     </c:when>   
                                     <c:when test="${evento_de_hoy.estaLleno()}">
                                         border-bottom-secondary
                                     </c:when>
                                 </c:choose>
                                 ">
                                <summary class="abrir-detalles-evento" 
                                         data-toggle="modal" data-target="#modalDetallesEvento" 
                                         data-id="${evento_de_hoy.idEvento}">
                                    <img class="card-img-top" src="${pageContext.request.contextPath}/img/event.jpg" alt="Imagen de evento.png">
                                    <div class="card-block px-3 pb-3">
                                        <h4 class="card-title mt-3">${evento_de_hoy.nombreEvento}</h4>
                                        <div class="card-text">
                                            <strong>Fecha:</strong> ${evento_de_hoy.fechaEvento} <br>
                                            <strong>Hora de inicio:</strong> ${evento_de_hoy.horaInicio} <br>
                                            <strong>Hora de fin:</strong> ${evento_de_hoy.horaFin} <br>
                                        </div>
                                    </div>
                                
                                    <div class="card-footer" style="text-align: center">
                                        <c:choose>
                                            <c:when test="${evento_de_hoy.estaDisponible()}">
                                                <strong class="align-middle text-success">Evento disponible</strong>
                                            </c:when>
                                            <c:when test="${evento_de_hoy.estaFinalizado()}">
                                                <strong class="align-middle text-danger">Evento finalizado</strong>
                                            </c:when>
                                            <c:when test="${evento_de_hoy.estaEnProceso()}">
                                                <strong class="align-middle text-warning">En proceso</strong>
                                            </c:when>
                                            <c:when test="${evento_de_hoy.estaLleno()}">
                                                <strong class="align-middle text-secondary">Sin aforo</strong>
                                            </c:when>
                                            <c:otherwise>
                                                <strong class="align-middle">${evento_de_hoy.estadoEvento}</strong>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </summary>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p><strong>No hay eventos disponibles</strong></p>
                </c:otherwise>
            </c:choose>
        </div>
            
            
        <h2>Eventos próximos</h2>
        <div class="row">
            <c:choose>
                <c:when test="${eventos_proximos!=null && eventos_proximos.size()>0}">
                    <c:forEach var="evento_proximo" items="${eventos_proximos}" >
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card 
                                <c:choose>
                                    <c:when test="${evento_proximo.estaDisponible()}">
                                        border-bottom-success
                                    </c:when>
                                    <c:when test="${evento_proximo.estaLleno()}">
                                        border-bottom-secondary
                                    </c:when>
                                </c:choose>">
                                <summary class="abrir-detalles-evento" data-toggle="modal" 
                                         data-target="#modalDetallesEvento"
                                         data-id="${evento_proximo.idEvento}">
                                    <img class="card-img-top" src="${pageContext.request.contextPath}/img/event.jpg" alt="Imagen de evento.png">
                                    <div class="card-block px-3 pb-3">
                                        <h4 class="card-title mt-3">${evento_proximo.nombreEvento}</h4>
                                        <div class="card-text">
                                            <strong>Fecha:</strong> ${evento_proximo.fechaEvento} <br>
                                            <strong>Hora de inicio:</strong> ${evento_proximo.horaInicio} <br>
                                            <strong>Hora de fin:</strong> ${evento_proximo.horaFin} <br>
                                        </div>
                                    </div>
                                </summary>
                                <div class="card-footer" style="text-align: center">
                                    <c:choose>
                                        <c:when test="${evento_proximo.estaDisponible()}">
                                            <strong class="align-middle text-success">Evento disponible</strong>
                                        </c:when>
                                        <c:when test="${evento_proximo.estaLleno()}">
                                            <strong class="align-middle text-secondary">Sin aforo</strong>
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
