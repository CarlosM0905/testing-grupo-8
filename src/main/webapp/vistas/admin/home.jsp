<%-- 
    Document   : home
    Created on : Oct 5, 2019, 4:52:09 PM
    Author     : josecarlos
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:basic-admin-template title="Index">
    <jsp:attribute name="content">
        INDEX
        <c:redirect url="/admin/supraeventos"></c:redirect>
        
    </jsp:attribute>
</mt:basic-admin-template>