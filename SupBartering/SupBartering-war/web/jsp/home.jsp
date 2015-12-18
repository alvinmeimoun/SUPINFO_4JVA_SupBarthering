<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <jsp:include page="../jspf/header.jspf" />
        </header>
        <h1>Je suis page accueil</h1>
        Etes vous connecté : ${requestScope.isAuthenticated}
        <footer>
            <jsp:include page="../jspf/footer.jspf" />
        </footer>
    </body>
</html>
