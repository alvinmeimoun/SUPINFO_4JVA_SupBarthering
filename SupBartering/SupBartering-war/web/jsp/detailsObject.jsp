<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <header>
            <jsp:include page="../jspf/header.jspf" />
        </header>
        
            <h1><c:out value="${object.title}" /></h1>
                <ul>
                    <p> Afficher la photo genre boncoin </p>
                    <li><c:out value="${object.description}" /></li>
                    <li><c:out value="${object.price} €"/></li>
                    <li><c:out value="${object.type.typeName}" /></li>
                    <li><c:out value="${object.user.userName}"/></li>
                </ul>
        <footer>
            <jsp:include page="../jspf/footer.jspf" />
        </footer>
    </body>
</html>
