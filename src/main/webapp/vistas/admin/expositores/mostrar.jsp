<%-- 
    Document   : ver-expositores
    Created on : Sep 29, 2019, 10:00:33 PM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-admin-template title="Expositores">
    <jsp:attribute name="content">
        <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="${pageContext.request.contextPath}/js/demo/datatables-demo.js"></script>
        
        <c:if test="${error != null && error.length() > 0}">
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </c:if>
                
        
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Expositores registrados</h1>
          
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Tabla de Expositores</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable">
                  <thead>
                    <tr>
                      <th>#</th>
                      <th>Nombre</th>
                      <th>Fecha nacimiento</th>
                      <th>Especialidad</th>
                      <th>Correo</th>
                      <th></th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="expositor" items="${expositores}" varStatus="loop">
                        <tr>
                            <td>${loop.index+1}</td>
                            <td>${expositor.nombreExpositor}</td>
                            <td>${expositor.fechaNacimiento}</td>
                            <td>${expositor.especialidadExpositor}</td>
                            <td>${expositor.correoExpositor}</td>
                            <td style="text-align: center">
                                <button class="btn btn-success btn-circle btn-sm btn-editar-expositor" 
                                        data-toggle="modal" data-target="#editar_expositor" 
                                        data-id="${expositor.idExpositor}">
                                    <em class="fas fa-edit" style="margin: 0px"></em>
                                </button>
                            </td>
                            <td style="text-align: center">
                                <button class="btn btn-danger btn-circle btn-sm btn-eliminar-expositor"
                                        data-toggle="modal" data-target="#eliminar_expositor"
                                        data-id="${expositor.idExpositor}" 
                                        data-expositor-nombre="${expositor.nombreExpositor}">
                                   <em class="fas fa-trash"  style="margin: 0px"></em>
                                </button>
                            </td>
                        </tr>  
                      </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          
          <!-- Incluir el modal de eliminar -->
          <%@ include file="eliminar.jsp" %> 
          
          <!-- Modal editar -->
            <div id="editar_expositor" class="modal fade" id="editar_expositor" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog ">
                <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Editar Expositor</h5>
                        <div class="pull-right">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                       </div>
                      </div>
                      <div id="editar-ambiente-body" class="modal-body" style="padding: 15px;">
                          <!-- Body que necesita ser cargado desde el servlet -->
                      </div>
                </div>
              </div>
            </div>
          
          
          
          <script>
              $('.btn-eliminar-expositor').click(function(){
                  //console.log('asdc');
                  $idExpositor = $(this).data('id');
                  $nombreExpositor = $(this).data('expositor-nombre');
                  
                  $("#eliminar_nombre_expositor").html($nombreExpositor);
                  $('#input_id_expositor').val($idExpositor);
              });
              
              $('.btn-editar-expositor').click(function (){
                  $idExpositor = $(this).data('id');
                  
                  $("#editar-ambiente-body").load("${pageContext.request.contextPath}/admin/expositores/editar?idExpositor="+$idExpositor);
              });
                
          </script>
    </jsp:attribute>
</mt:basic-admin-template>
