
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
         <style>
            table {
                width: 80%; 
                margin: auto;
                border-collapse: collapse;
            }
            
            table tr td, table tr th {
                text-align: center;
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
         <header>
            <jsp:include page="../jspf/header.jspf" />
        </header>
      <c:choose>
            <c:when test="${not empty objects}">
                <table>
                    <tr>
                        <th>Photo</th>
                        <th>Titre</th>
                        <th>Description</th>
                        <th>Type</th>
                        <th>Prix</th>
                        <c:if test="${not empty user}">
                            <th>Action</th>
                        </c:if>
                        <th>Action</th>
                    </tr>
                   
                        <c:forEach items="${objects}" var="object">
                        <tr>
                           <c:url value="/deleteObject?id=${object.id}" var="deleteUrl" />
                           <td><img src="<c:out value="${object.pictureUrl}" />.jpg"</td>
                            <td><c:out value="${object.title}" /></td>
                            <td><c:out value="${object.description}" /></td>
                            <td><c:out value="${object.type.typeName}" /></td>
                            <td><c:out value="${object.price} €"/></td>
                            <c:if test="${not empty user}">
                                <td>
                                    <a href="${deleteUrl}">Supprimer</a>
                                </td>
                            </c:if>
                            <td> 
                            <c:url value="/viewDetailsObject?id=${object.id}" var="detailsUrl" />
                            <a href="${detailsUrl}">Voir les détails</a>
                            </td>
                        </tr>
                        </c:forEach>
                  
                </table>
            </c:when>
            <c:otherwise>
                <p>Aucun articles.</p>
            </c:otherwise>
        </c:choose>
        
        <c:if test="${not empty user}">
            <c:url value="/addObject" var="addObjectUrl" />
            <a href="${addObjectUrl}">Ajouter un objet</a>
        </c:if>
            
        <footer>
            <jsp:include page="../jspf/footer.jspf" />
        </footer>
    </body>
</html>
