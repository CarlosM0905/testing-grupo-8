<%-- 
    Document   : calendario-eventos
    Created on : Sep 29, 2019, 9:56:24 PM
    Author     : josecarlos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-admin-template title="Calendario eventos">
    <jsp:attribute name="content">
        <link href='${pageContext.request.contextPath}/vendor/fullcalendar/packages/core/main.css' rel='stylesheet' />
        <link href='${pageContext.request.contextPath}/vendor/fullcalendar/packages/daygrid/main.css' rel='stylesheet' />
        <script src='${pageContext.request.contextPath}/vendor/fullcalendar/packages/core/main.min.js'></script>
        <script src='${pageContext.request.contextPath}/vendor/fullcalendar/packages/interaction/main.js'></script>
        <script src='${pageContext.request.contextPath}/vendor/fullcalendar/packages/daygrid/main.js'></script>
        <script src='${pageContext.request.contextPath}/vendor/fullcalendar/packages/list/main.js'></script>
        
        <script src='${pageContext.request.contextPath}/vendor/fullcalendar/packages/core/locales/es.js'></script>
        <div id="calendar">
            
        </div>
        
        <script>
          $(function() {
            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {
              plugins: [ 'interaction', 'list', 'dayGrid' ],
              locale: 'es',
              defaultDate: new Date().toJSON(),
              editable: false,
              eventLimit: true, // allow "more" link when too many events
              header: {
                left: 'prev,next today',
                center: 'title',
                right: 'dayGridMonth,listYear'
              },

              events: [
                <c:forEach var="supraevento" items="${supraeventos}">
                  {
                    title: "${supraevento.nombreSupraevento}",
                    start: "${supraevento.fechaInicio}",
                    end:   "${supraevento.fechaFin}",
                    extendedProps: {
                        id: "${supraevento.idSupraevento}"
                    }
                  },
                </c:forEach>
              ],
              eventClick: function(info){
                  //alert("Evento seleccionado: "+info.event.title);
                  $id = info.event.extendedProps.id;
                  window.location.replace("${pageContext.request.contextPath}/admin/supraeventos/detalles?idSupraevento="+$id);
              }
            });

            calendar.render();
          });

        </script>
        <style>
            #loading {
              display: none;
              position: absolute;
              top: 10px;
              right: 10px;
            }

            #calendar {
              max-width: 1000px;
              margin: 0 auto;
              color: #000;
            }
           
            .fc-event{
                cursor: pointer;
            }
            
            .fc-list-item{
                cursor: pointer;
            }
        </style>

    </jsp:attribute>
</mt:basic-admin-template>