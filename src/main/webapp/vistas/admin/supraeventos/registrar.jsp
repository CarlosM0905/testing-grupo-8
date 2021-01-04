<%-- 
    Document   : registrar-evento
    Created on : Sep 29, 2019, 9:53:46 PM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-admin-template title="Registrar evento">
    <jsp:attribute name="content">
        <form method="POST" action="${pageContext.request.contextPath}/admin/supraeventos/registrar" id="form-registrar-supraevento">
            
            <h2>Nuevo evento</h2>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group"> <!-- Full Name -->
                        <label for="nombre_evento" class="control-label">Nombre evento</label>
                        <input type="text" class="form-control" id="nombre_supraevento" name="nombre_supraevento" required
                               pattern="[a-zA-ZÀ-ÿ\u00f1\u00d1][ a-zA-ZÀ-ÿ\u00f1\u00d1]*" title="Ingrese un nombre válido"/>
                    </div>	
                </div>
                <div class="col-md-6">
                    <div class="form-group"> <!-- Full Name -->
                        <label for="numero_entradas" class="control-label">Entradas disponibles</label>
                        <input type="text" class="form-control" id="entradas_disponibles" name="entradas_disponibles" required
                               pattern="[1-9][0-9]{1,2}" title="El campo solo acepta números y como minimo deben tener un valor de 10 y menor a 1000">
                    </div>	
                </div>
            </div>
            
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="fecha_inicio" class="control-label">Fecha inicio</label>
                        <input type='text' class="form-control my_datepicker" name="fecha_inicio" id="input_fecha_inicio" required
                               pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                               title="Debe ingresar una fecha válida"/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="fecha_fin" class="control-label">Fecha fin</label>
                        <input type='text' class="form-control my_datepicker" name="fecha_fin" id="input_fecha_fin" required
                               pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                               title="Debe ingresar una fecha válida"/>
                    </div>
                </div>
            </div>
            
            <!-- Aqui se van agregando las ponencias -->
            <div id="ponencias">
                
            </div>
            
            <div class="form-group"> <!-- Submit Button -->
                <button type="button" id="btn-agregar-ponencia" class="btn btn-success">Agregar ponencia</button>
            </div>
            
            <div class="form-group"> <!-- Submit Button -->
                <a href="${pageContext.request.contextPath}/admin/supraeventos" class="btn btn-secondary">Cancelar</a>
                <button type="submit" class="btn btn-primary">Crear evento</button>
            </div>
        </form>
                
        <script>
            $(function() {
                var today = new Date();
                var dd = String(today.getDate()).padStart(2, '0');
                var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
                var yyyy = today.getFullYear();

                today = yyyy + '-' + mm + '-' + dd;
                
                $numPonencias = 0;
                
                $('#btn-agregar-ponencia').click(function(event){
                    $numPonencias++;
                    
                    $divNuevaPonencia = $("<div/>", {
                        id: "ponencia" + $numPonencias
                    });
                    
                    $btn_eliminar = $("<button/>",
                    {
                        text: 'Eliminar ponencia',
                        "class": "btn btn-danger"
                    });
                    
                    $div_button = new $("<div/>", {
                        "class": "form-group"
                    }).html($btn_eliminar);
                    
                    $('#ponencias').append($divNuevaPonencia);
                   
                    $divNuevaPonencia.load("${pageContext.request.contextPath}/admin/eventos/registrar");
                    $btn_eliminar.click(function (){
                        $divNuevaPonencia.remove();
                        $(this).remove();
                    });
                    
                   //$('#'+$divId).append($btn_eliminar);
                });
                
                $('#form-registrar-supraevento').submit(function(e){
                    if($numPonencias === 0){
                        e.preventDefault(e);
                        alert("Debe registrar como mínimo una ponencia para el evento");
                    } else if ($('#input_fecha_inicio').val() > $('#input_fecha_fin').val()){
                        e.preventDefault(e);
                        alert("La fecha de inicio del evento no puede ser posterior a la fecha de fin");
                        $('#input_fecha_fin').focus();
                    } else if ($('#input_fecha_inicio').val() <= today){
                        e.preventDefault(e);
                        alert("La fecha de inicio del evento no puede ser anterior ni igual a la fecha de hoy");
                        $('#input_fecha_inicio').focus();
                    } else {
                        $("#form-registrar-supraevento input[name=fecha_evento]").each(function(i) {
                            if($(this).val() < $('#input_fecha_inicio').val() || $(this).val() > $('#input_fecha_fin').val()) {
                                e.preventDefault(e);
                                alert("La fecha de una ponencia no puede estar fuera del rango de fechas del evento");
                                $(this).focus();
                                return false;
                            }
                        });
                        
                        
                    }
                }); 
            });
        </script>
    </jsp:attribute>
</mt:basic-admin-template>