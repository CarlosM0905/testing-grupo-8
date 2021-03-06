<%-- 
    Document   : 400
    Created on : Oct 13, 2019, 12:11:08 PM
    Author     : josecarlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/sb-admin-2.min.js"></script>
        <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        
        <title>400</title>
    </head>
    <div clas="container">
        <div class="container-fluid">
            <!-- 404 Error Text -->
            <div class="text-center">
                <div class="error mx-auto" data-text="404">400</div>
                <p class="lead text-gray-800 mb-5">Bad request: Los parametros no son los correctos</p>
                <p class="text-gray-500 mb-0"></p>
                
                <a href="#" class="btn btn-secondary btn-icon-split" onclick="history.back()">
                    <span class="icon text-white-50">
                        <em class="fas fa-arrow-left"></em>
                    </span>
                    <span class="text">Volver</span>
                </a>
            </div>
        </div>
    </div>
</html>
