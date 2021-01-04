<%-- 
    Document   : mostrar
    Created on : Oct 2, 2019, 12:01:21 PM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-admin-template title="Ambientes">
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
          <h1 class="h3 mb-2 text-gray-800">Ambientes registrados</h1>
          
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Tabla de ambientes</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable">
                  <thead>
                    <tr>
                      <th>#</th>
                      <th>Nombre Ambiente</th>
                      <th>Capacidad</th>
                      <th></th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="ambiente" items="${ambientes}" varStatus="loop">
                        <tr>
                            <td>${loop.index+1}</td>
                            <td>${ambiente.nombreAmbiente}</td>
                            <td>${ambiente.capacidad}</td>
                            <td style="text-align: center">
                                <button href="#"
                                        class="btn btn-success btn-circle btn-sm btn-editar" 
                                        data-toggle="modal" data-target="#editar_ambiente" 
                                        data-id="${ambiente.idAmbiente}" data-ambiente-nombre="${ambiente.nombreAmbiente}"
                                        >
                                    <em class="fas fa-edit" style="margin: 0px"></em>
                                </button>
                            </td>
                            <td style="text-align: center">
                                <button href="#" class="btn btn-danger btn-circle btn-sm btn-eliminar" 
                                        data-toggle="modal" data-target="#eliminar_ambiente"
                                        data-id="${ambiente.idAmbiente}" 
                                        data-ambiente-nombre="${ambiente.nombreAmbiente}"
                                        >
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
          
          <!-- Modal de editar -->
            <div id="editar_ambiente" class="modal fade" id="eliminar_ambiente"
                 tabindex="-1" aria-labelledby="exampleModalLabel" 
                 aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Editar ambiente</h5>
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
              $('.btn-eliminar').click(function(){
                  //console.log('asdc');
                  $idAmbiente = $(this).data('id');
                  $nombreAmbiente = $(this).data('ambiente-nombre');
                  
                  $("#eliminar_nombre_ambiente").html($nombreAmbiente);
                  $('#input_id_ambiente').val($idAmbiente);
              });
              
              $('.btn-editar').click(function (){
                  $idAmbiente = $(this).data('id');
                  
                  $("#editar-ambiente-body").load("${pageContext.request.contextPath}/admin/ambientes/editar?idAmbiente="+$idAmbiente);
              });
                
          </script>
          
    </jsp:attribute>
</mt:basic-admin-template>

