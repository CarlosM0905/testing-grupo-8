<%-- 
    Document   : detalles
    Created on : Oct 15, 2019, 9:34:18 PM
    Author     : josecarlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Modal con los detalles del evento seleccionado -->
<div id="modalDetallesEvento" class="modal fade" id="modalDetallesEvento"
         tabindex="-1" aria-labelledby="exampleModalLabel" 
         aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Evento</h5>
                <div class="pull-right">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
               </div>
              </div>
              <div id="detalles-evento-body" class="modal-body" style="padding: 15px;">
                  <!-- Body que necesita ser cargado desde el servlet -->
              </div>
        </div>
    </div>
</div>

<script>
    $('.abrir-detalles-evento').click(function (){
          $idEvento = $(this).data('id');
          $("#detalles-evento-body").load("${pageContext.request.contextPath}/participante/eventos/detalles?idEvento="+$idEvento);
      });
</script>