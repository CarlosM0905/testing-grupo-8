<%-- 
    Document   : detalles
    Created on : Nov 1, 2019, 11:10:41 AM
    Author     : josecarlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h3>Ponencia</h3>
<div class="row">
    <div class="col-md-6">
        <div class="form-group"> <!-- Full Name -->
            <label class="control-label">Nombre ponencia</label>
            <input type="text" class="form-control" value="${evento.nombreEvento}" readonly>
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group"> <!-- Full Name -->
            <label class="control-label">Estado ponencia</label>
            <input type="text" class="form-control" id="nombre_evento" 
                   value="${evento.estadoEvento}" readonly>
        </div>
    </div>
</div>

<div class="form-group">
    <label for="dia_evento" class="control-label">Dia del evento</label>
    <input type='text' class="form-control" 
           value="${evento.fechaEvento}" readonly/>
</div>

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
        
<div class="row">
    <div class="col-md-6">
        <div class="form-group"> 
            <label for="ambiente" class="control-label">Ambiente</label>
            <input type='text' class="form-control" 
                   name="ambiente" value="${ambiente.nombreAmbiente}" readonly/>
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group"> 
            <label for="expositor" class="control-label">Expositor</label>
            <input type='text' class="form-control" 
                   name="expositor" value="${expositor.nombreExpositor}" readonly/>				
        </div>
    </div>
</div>
        

<div class="row">
    <div class="col-md-6">
        <div class="form-group"> 
            <label for="ambiente" class="control-label">Capacidad del ambiente</label>
            <input type='text' class="form-control" 
                   name="ambiente" value="${ambiente.capacidad}" readonly/>
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group"> 
            <label for="expositor" class="control-label">Numero de inscritos</label>
            <input type='text' class="form-control" 
                   name="expositor" value="${evento.numeroInscritos}" readonly/>				
        </div>
    </div>
</div>
