<%-- 
    Document   : detalles
    Created on : Oct 13, 2019, 11:38:06 AM
    Author     : josecarlos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

            <div class="form-group"> <!-- Full Name -->
                <label for="nombre_evento" class="control-label">Nombre evento</label>
                <input type="text" class="form-control" id="nombre_evento" 
                       value="${evento_escogido.nombreEvento}" readonly>
            </div>	

            <div class="form-group">
                <label for="dia_evento" class="control-label">Dia del evento</label>
                <input type='text' class="form-control" 
                       value="${evento_escogido.fechaEvento}" readonly/>
            </div>

              <div class="row">
                <div class="col-md-6">
            <div class="form-group">
                <label for="hora_inicio" class="control-label">Hora inicio</label>
                <input type='time' class="form-control" 
                       value="${evento_escogido.horaInicio}" readonly/>
            </div>
                </div>
                <div class="col-md-6">
            <div class="form-group">
                <label for="hora_fin" class="control-label">Hora fin</label>
                <input type='time' class="form-control" 
                       value="${evento_escogido.horaFin}" readonly/>
            </div>
                </div>
              </div>
            <div class="form-group"> 
                <label for="ambiente" class="control-label">Ambiente</label>
                <input type='text' class="form-control" 
                       value="${ambiente.nombreAmbiente}" readonly/>
            </div>

            <div class="form-group"> 
                <label for="expositor" class="control-label">Expositor</label>
                <input type='text' class="form-control" 
                       value="${expositor.nombreExpositor}" readonly/>				
            </div>

            <div class="form-group"> <!-- Submit Button -->
                <c:choose>
                    <c:when test="${evento_escogido.estaDisponible()}">
                        
                        <c:choose>
                            <c:when test="${!estaInscrito}">
                                <form method="POST" action="${pageContext.request.contextPath}/participante/eventos/inscripcion/registrar" >
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <input type="hidden" name="idEvento" value="${evento_escogido.idEvento}"/>
                                    <button type="submit" class="btn btn-primary">Inscribirse</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form method="POST" action="${pageContext.request.contextPath}/participante/eventos/inscripcion/anular">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <input type="hidden" name="idEvento" value="${evento_escogido.idEvento}"/>
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
        
