<%-- 
    Document   : eliminar
    Created on : Oct 6, 2019, 5:41:44 PM
    Author     : josecarlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="modal fade" id="eliminar_ambiente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Eliminar ambiente</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <p>¿Está seguro que quiere eliminar el ambiente: <strong id="eliminar_nombre_ambiente"></strong>?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <form method="POST" action="${pageContext.request.contextPath}/admin/ambientes/eliminar">
            <input type="hidden" id="input_id_ambiente" name="id_ambiente">
            <button type="submit" class="btn btn-danger">Confirmar</button>
        </form>
      </div>
    </div>
  </div>
</div>

