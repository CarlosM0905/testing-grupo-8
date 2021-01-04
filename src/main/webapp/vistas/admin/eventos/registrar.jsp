<%-- 
    Document   : registrar-ponencia
    Created on : Oct 31, 2019, 5:08:58 PM
    Author     : josecarlos
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h4>Nueva ponencia</h4>
<div class="row">
    <div class="col-md-6">
        <div class="form-group"> <!-- Full Name -->
            <label for="nombre_evento" class="control-label">Nombre ponencia</label>
            <input type="text" class="form-control nombre-ponencia" id="nombre_evento" name="nombre_evento" required
                   pattern="[a-zA-ZÀ-ÿ\u00f1\u00d1][ a-zA-ZÀ-ÿ\u00f1\u00d1]*" title="Ingrese un nombre válido"/>
        </div>	
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label for="fecha" class="control-label">Fecha ponencia</label>
            <input type='text' class="form-control my_datepicker fecha-ponencia" name="fecha_evento" required
                   pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                   title="Debe ingresar una fecha válida"/>
        </div>
    </div>            
</div>

<div class="row div-fechas">
    <div class="col-md-6">
        <div class="form-group">
            <label for="hora_inicio" class="control-label">Hora inicio</label>
            <input type='text' class="form-control my_timepicker hora-inicio" name="hora_inicio" required
                   pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]" title="Debe ingresar una hora válida" id="input_hora_inicio"
                   />
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label for="hora_fin" class="control-label">Hora fin</label>
            <input type='text' class="form-control my_timepicker hora-fin" name="hora_fin" required
                   pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]" title="Debe ingresar una hora válida" id="input_hora_fin"/>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-6">
        <div class="form-group"> 
            <label for="id_ambiente" class="control-label">Ambiente</label>
            <select class="form-control id-ambiente" name="id_ambiente" required>
                <option disabled selected value> -- Escoja un ambiente -- </option>
                <c:forEach items="${ambientes}" var="ambiente">
                    <option value="${ambiente.idAmbiente}">${ambiente.nombreAmbiente} - Capacidad: ${ambiente.capacidad}</option>
                </c:forEach>
            </select>					
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group"> 
            <label for="expositor" class="control-label">Expositor</label>
            <select class="form-control id-expositor" name="id_expositor" required>
                <option disabled selected value> -- Escoja un expositor -- </option>
                <c:forEach items="${expositores}" var="expositor">
                    <option value="${expositor.idExpositor}">${expositor.nombreExpositor} - Especialidad: ${expositor.especialidadExpositor}</option>
                </c:forEach>
            </select>					
        </div>
    </div>
</div>
      
<script type="text/javascript">
    $(function () {
        
        $('.my_datepicker').datepicker({
            language: 'es',
            currentText: 'Hoy',
            format: 'yyyy-mm-dd',
            autoclose: true
        });

        // Time Picker Initialization
        $('.my_timepicker').clockpicker({
            autoclose: true,
        });
        
        $('.hora-inicio:last').change(function(){
            if($(this)[0].checkValidity() && $(this).val() < '06:00'){
                alert("La hora de inicio no puede ser anterior a las 06:00");
                $(this).val("");
            } else if($(this)[0].checkValidity() && $(this).closest(".div-fechas").find('.hora-fin')[0].checkValidity()){
                //alert('Horas validas');
                //console.log("Hora inicio: " + $(this).val());
                //console.log("Hora fin: " + $(this).closest(".div-fechas").find('.hora-fin').val());
                
                if($(this).val() >= $(this).closest(".div-fechas").find('.hora-fin').val()){
                    alert('La hora de inicio no puede ser mayor o igual a la hora de fin');
                    $(this).val("");
                }
            }
        });
        
        $('.hora-fin:last').change(function(){
            if($(this)[0].checkValidity() && $(this).closest(".div-fechas").find('.hora-inicio')[0].checkValidity()){
                //alert('Horas validas');
                //console.log("Hora inicio " + $(this).closest(".div-fechas").find('.hora-inicio').val());
                //console.log("Hora fin " + $(this).val());
                
                if($(this).val() <= $(this).closest(".div-fechas").find('.hora-inicio').val()) {
                    alert('La hora de fin no puede ser menor o igual a la hora de inicio');
                    $(this).val("");
                }
            }
        });
    });
</script>