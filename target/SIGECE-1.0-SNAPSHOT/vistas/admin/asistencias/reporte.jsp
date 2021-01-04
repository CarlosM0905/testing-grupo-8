<%-- 
    Document   : reporte
    Created on : Nov 8, 2019, 9:29:29 AM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-admin-template title="Reporte asistencia">
    <jsp:attribute name="content">
        <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.min.js"></script>
        <!-- Page level custom scripts -->
        <script src="${pageContext.request.contextPath}/js/demo/datatables-demo.js"></script>
        
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Asistencias de la ponencia: <strong>${evento.nombreEvento}</strong> </h1>
          
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Asistencias de la ponencia</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable">
                  <thead>
                    <tr>
                        <th>#</th>
                        <th>Nombre asistente</th>
                        <th>Estado asistencia</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="asistencia" items="${asistencias}" varStatus="loop">
                        <tr>
                            <td>${loop.index+1}</td>
                            <td>${asistencia.nombreParticipante}</td>
                            <td>${asistencia.estadoAsistencia}</td>
                        </tr>
                      </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        
          <div class="row">
                <a href="#" class="btn btn-secondary" onclick="history.back()">
                    Volver
                </a>
          </div>
    </jsp:attribute>
</mt:basic-admin-template>
