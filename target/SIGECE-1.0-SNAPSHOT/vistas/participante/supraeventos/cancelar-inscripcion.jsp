<%-- 
    Document   : cancelar-inscripcion
    Created on : Oct 15, 2019, 10:21:12 PM
    Author     : josecarlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="cancelar_inscripcion_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Cancelar inscripcion</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <p>¿Está seguro que quiere cancelar su inscripcion al evento: <strong id="nombre_supraevento_cancelar"></strong>?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <form method="POST" action="${pageContext.request.contextPath}/participante/supraeventos/inscripcion/anular">
            <input type="hidden" id="input_idSupraevento" name="idSupraevento">
            <button type="submit" class="btn btn-danger">Confirmar</button>
        </form>
      </div>
    </div>
  </div>
</div>

<script>
    $('.btn-cancelar-inscripcion').click(function(){
        //console.log('asdc');
        $idSupraevento = $(this).data('id');
        $nombreSupravento = $(this).data('supraevento-nombre');

        $("#nombre_supraevento_cancelar").html($nombreSupravento);
        $('#input_idSupraevento').val($idSupraevento);
  });
</script>