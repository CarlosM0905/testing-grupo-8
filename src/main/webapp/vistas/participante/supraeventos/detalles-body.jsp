<%-- 
    Document   : detalles
    Created on : Oct 13, 2019, 11:38:06 AM
    Author     : josecarlos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

            <div class="form-group"> <!-- Full Name -->
                <label class="control-label">Nombre evento</label>
                <input type="text" class="form-control" id="nombre_evento" 
                       value="${supraevento.nombreSupraevento}" readonly>
            </div>	

            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label">Fecha inicio</label>
                        <input type='text' class="form-control" 
                               value="${supraevento.fechaInicio}" readonly/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label">Fecha inicio</label>
                        <input type='text' class="form-control" 
                               value="${supraevento.fechaFin}" readonly/>
                    </div>
                </div>
            </div>
           
            <h4>Ponencias</h4>
            <c:forEach var="evento" items="${eventos}">
                <h4><strong>${evento.nombreEvento}</strong></h4>
                <h3><strong>${evento.fechaEvento}</strong></h3>

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
                    
           </c:forEach>
                    
            <div class="form-group"> <!-- Submit Button -->
                <c:choose>
                    <c:when test="${supraevento.estaDisponible() || (supraevento.estaLleno() && estaInscrito)}">
                        <c:choose>
                            <c:when test="${!estaInscrito}">
                                <form method="POST" action="${pageContext.request.contextPath}/participante/supraeventos/inscripcion/registrar" >
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <input type="hidden" name="idSupraevento" value="${supraevento.idSupraevento}"/>
                                    <button type="submit" class="btn btn-primary">Inscribirse</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form method="POST" action="${pageContext.request.contextPath}/participante/supraeventos/inscripcion/anular">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <input type="hidden" name="idSupraevento" value="${supraevento.idSupraevento}"/>
                                    <button type="submit" class="btn btn-danger">Anular inscripcion</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        Evento no disponible
                    </c:otherwise>
                </c:choose>
            </div>
        
