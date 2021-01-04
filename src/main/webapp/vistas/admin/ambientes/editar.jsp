<%-- 
    Document   : editar
    Created on : Oct 6, 2019, 5:35:00 PM
    Author     : josecarlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<form role="form" method="POST" action="${pageContext.request.contextPath}/admin/ambientes/editar">
    
  <div class="row">
    <div class="col-md-12">
      <div class="form-group">
        <label>Nombre Ambiente</label>
        <input type="text" name="nombre_ambiente" value="${ambiente.nombreAmbiente}" class="form-control" required
               pattern="[a-zA-ZÀ-ÿ\u00f1\u00d1][ a-zA-Z0-9À-ÿ\u00f1\u00d1]*" title="El campo debe empezar con una letra del alfabeto">
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="form-group">
        <label>Capacidad</label>
        <input type="text" name="capacidad_ambiente" value="${ambiente.capacidad}" class="form-control" required
               pattern="[1-9][0-9]{0,2}" title="El campo solo acepta dígitos. El campo debe ser mayor a 0 y menor a 1000" required/>
      </div>
    </div>
  </div>

  <div class="modal-footer">
    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
    <input type="hidden" id="input_id_ambiente" name="id_ambiente" value="${ambiente.idAmbiente}">
    <button type="submit" class="btn btn-primary">
        Editar Ambiente
    </button>
  </div>
</form>
