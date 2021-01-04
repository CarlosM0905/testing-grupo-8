<%-- 
    Document   : detalles
    Created on : Oct 9, 2019, 9:04:28 AM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-admin-template title="Detalles evento">
    <jsp:attribute name="content">
        <form>
            <h2>Detalles del evento</h2>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group"> <!-- Full Name -->
                        <label for="nombre_evento" class="control-label">Nombre evento</label>
                        <input type="text" class="form-control" id="nombre_evento" 
                               value="${supraevento.nombreSupraevento}" readonly>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group"> <!-- Full Name -->
                        <label for="nombre_evento" class="control-label">Estado evento</label>
                        <input type="text" class="form-control" id="nombre_evento" 
                               value="${supraevento.estadoSupraevento}" readonly>
                    </div>
                </div>
            </div>
                    
                    
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="dia_evento" class="control-label">Dia de inicio</label>
                        <input type='text' class="form-control" value="${supraevento.fechaInicio}" readonly/>
                    </div>
                </div>
                    
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="dia_evento" class="control-label">Dia de fin</label>
                        <input type='text' class="form-control" value="${supraevento.fechaFin}" readonly/>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group"> 
                        <label for="expositor" class="control-label">Entradas</label>
                        <input type='text' class="form-control" 
                               name="expositor" value="${supraevento.entradasDisponibles}" readonly/>				
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group"> 
                        <label for="expositor" class="control-label">Numero de inscritos</label>
                        <input type='text' class="form-control" 
                               name="expositor" value="${supraevento.numeroInscritos}" readonly/>				
                    </div>
                </div>
            </div>
            
            <div id="eventos">
                <c:forEach var="evento" items="${eventos}">
                    <h3>Ponencia: <strong>${evento.nombreEvento}</strong> Fecha: <strong>${evento.fechaEvento}</strong> </h3>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="hora_inicio" class="control-label">Hora inicio</label>
                                <input type='time' class="form-control" 
                                       value="${evento.horaInicio}" readonly/>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="hora_fin" class="control-label">Hora fin</label>
                                <input type='time' class="form-control" 
                                       value="${evento.horaFin}" readonly/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group"> <!-- Submit Button -->
                        <a href="${pageContext.request.contextPath}/admin/eventos/asistencias?idEvento=${evento.idEvento}"  class="btn btn-danger">Ver reporte de asistencia</a>
                    </div>    
                </c:forEach>
            </div>
                    
            <div class="form-group"> <!-- Submit Button -->
                <a href="${pageContext.request.contextPath}/admin/supraeventos" class="btn btn-primary">Volver al calendario de eventos</a>
            </div>
        </form>
    </jsp:attribute>
</mt:basic-admin-template>