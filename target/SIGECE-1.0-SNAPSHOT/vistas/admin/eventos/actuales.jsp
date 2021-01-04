<%-- 
    Document   : mis-eventos
    Created on : Oct 11, 2019, 1:26:54 PM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-admin-template title="Eventos actuales">
    <jsp:attribute name="content">
        <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.min.js"></script>
        <!-- Page level custom scripts -->
        <script src="${pageContext.request.contextPath}/js/demo/datatables-demo.js"></script>
        
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Ponencias actuales</h1>
          
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Ponencias llevándose a cabo</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable">
                  <thead>
                    <tr>
                        <th>#</th>
                        <th>Nombre evento</th>
                        <th>Hora inicio</th>
                        <th>Hora fin</th>
                        <th>Numero inscritos</th>
                        <th>Tomar asistencia</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="evento" items="${eventos}" varStatus="loop">
                        <tr>
                            <td>${loop.index+1}</td>
                            <td>${evento.nombreEvento}</td>
                            <td>${evento.horaInicio}</td>
                            <td>${evento.horaFin}</td>
                            <td>${evento.numeroInscritos}</td>
                            <td>
                                <a class="btn btn-success btn-circle btn-sm"
                                   href="${pageContext.request.contextPath}/admin/asistencias/evento?idEvento=${evento.idEvento}">
                                    <em class="fas fa-edit" style="margin: 0px"></em>
                                </a>
                            </td>
                        </tr>
                      </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        
    </jsp:attribute>
</mt:basic-admin-template>
