<%-- 
    Document   : editar
    Created on : Oct 7, 2019, 10:43:46 PM
    Author     : josecarlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
    
<form role="form" method="POST" action="${pageContext.request.contextPath}/admin/expositores/editar" id="form-editar-expositor">
  <div class="row">
    <div class="col-md-12">
      <div class="form-group">
        <label>Nombre Expositor</label>
        <input type="text" value="${expositor.nombreExpositor}" 
               class="form-control" name="nombre_expositor" required
               pattern="[a-zA-ZÀ-ÿ\u00f1\u00d1][ a-zA-ZÀ-ÿ\u00f1\u00d1]*" title="Ingrese un nombre válido"/>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="form-group">
        <label>Especialidad</label>
        <input type="text" value="${expositor.especialidadExpositor}" 
               class="form-control" name="especialidad_expositor" required
               pattern="[a-zA-ZÀ-ÿ\u00f1\u00d1][ a-zA-ZÀ-ÿ\u00f1\u00d1]*" title="Ingrese una especialidad válida"/>
      </div>
    </div>
  </div>
  
    <div class="row">
        <div class="col-md-12">
          <div class="form-group">
            <label>Correo</label>
            <input type="text" value="${expositor.correoExpositor}" 
                   class="form-control" name="correo_expositor" required
                   pattern="([a-z0-9_\.-]+)@((gmail.com)|(unmsm.edu.pe)|(hotmail.com))" title="Debe ingresar un correo válido. Se aceptan los dominios gmail.com, hotmail.com y unmsm.edu.pe">
          </div>
        </div>
    </div>

               
    <div class="row">
        <div class="col-md-12">
          <div class="form-group">
            <label>Fecha nacimiento</label>
            <input type="text" value="${expositor.fechaNacimiento}" 
                   class="form-control my_datepicker" name="fecha_nacimiento" required id="input_fecha_nacimiento"
                   pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                   title="Debe ingresar una fecha válida. Ejm: 2000-01-01"/>
          </div>
        </div>
    </div>
  
    <c:if test="${error != null && error.length() > 0}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>
                    
               
  <div class="modal-footer">
    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
    <input type="hidden" id="input_id_ambiente" name="id_expositor" value="${expositor.idExpositor}"/>
    <button type="submit" class="btn btn-primary">
        Editar Expositor
    </button>
  </div>
</form>
    
<script>
    $(function() {
        var today = new Date();
        var anioMinimo = today.getFullYear() - 15;
        today.setFullYear(anioMinimo);
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();

        today = yyyy + '-' + mm + '-' + dd;

        $('#form-editar-expositor').submit(function(e){
            if ($('#input_fecha_nacimiento').val() > today){
                e.preventDefault(e);
                alert("El expositor debe tener tener como mínimo 15 años ");
                $('#input_fecha_nacimiento').focus();
            }
        }); 
    });
</script>