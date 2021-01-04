<%-- 
    Document   : registrar-expositor
    Created on : Sep 29, 2019, 9:59:12 PM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-admin-template title="Registrar expositor">
    <jsp:attribute name="content">
        <form method="POST" action="${pageContext.request.contextPath}/admin/expositores/registrar" id="form-registrar-expositor">
            <div class="form-group"> <!-- Full Name -->
                <label for="nombre_expositor" class="control-label">Nombre del Expositor</label>
                <input type="text" class="form-control" id="nombre_expositor" name="nombre_expositor" required
                       pattern="[a-zA-ZÀ-ÿ\u00f1\u00d1][ a-zA-ZÀ-ÿ\u00f1\u00d1]*" title="Ingrese un nombre válido"/>
            </div>	
            
            <div class="form-group"> <!-- Full Name -->
                <label for="edad_expositor" class="control-label">Fecha de nacimiento</label>
                <input type="text" class="form-control my_datepicker" id="input_fecha_nacimiento" name="fecha_nacimiento" required
                       pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                       title="Debe ingresar una fecha válida"/>
            </div>	
            
            <div class="form-group"> <!-- Full Name -->
                <label for="especialidad_expositor" class="control-label">Especialidad</label>
                <input type="text" class="form-control" id="especialidad_expositor" name="especialidad_expositor" required
                       pattern="[a-zA-ZÀ-ÿ\u00f1\u00d1][ a-zA-ZÀ-ÿ\u00f1\u00d1]*" title="Ingrese una especialidad válida"/>
            </div>	
            
            <div class="form-group"> <!-- Full Name -->
                <label for="correo_expositor" class="control-label">Correo</label>
                <input type="text" class="form-control" id="correo_expositor" name="correo_expositor" required
                       pattern="([a-z0-9_\.-]+)@((gmail.com)|(unmsm.edu.pe)|(hotmail.com))" title="Debe ingresar un correo válido. Se aceptan los dominios gmail.com, hotmail.com y unmsm.edu.pe">
            </div>	
            
            <c:if test="${error != null && error.length() > 0}">
                <div class="alert alert-danger" role="alert">
                    ${error}
                </div>
            </c:if>
            
            <div class="form-group"> <!-- Submit Button -->
                <a href="${pageContext.request.contextPath}/admin/expositores" class="btn btn-secondary">Cancelar</a>
                <button type="submit" class="btn btn-primary">Registrar</button>
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
                
                $('#form-registrar-expositor').submit(function(e){
                    if ($('#input_fecha_nacimiento').val() > today){
                        e.preventDefault(e);
                        alert("El expositor debe tener tener como mínimo 15 años ");
                        $('#input_fecha_nacimiento').focus();
                    }
                }); 
            });
        </script>
    </jsp:attribute>
</mt:basic-admin-template>
