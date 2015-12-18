
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bartering - AddObject</title>
    </head>
    
    <body>
        
        <form action="upload" method="POST" enctype="multipart/form-data">
            
            <div>
                <label for="title">Title</label>
                <input type="text" id="title" name="title" />
            </div>
            
            <div>
                <label for="description">Description</label>
                <input type="text" id="description" name="description" />
            </div>
            
            <div>
                <label for="price">Price</label>
                <input type="text" id="price" name="price" />
            </div>
            
            <div>
                <label for="type">Type</label>
                <select id="type" name="type">
                    <c:forEach items="${types}" var="type">
                        <option value="${type.id}">
                            <c:out value="${type.typeName}"/>
                        </option>
                    </c:forEach>
                </select>
                        
                <input type="file" name="file" />
                <input type="submit" value="Upload"/>
        
            </div>
            
            <div>
                <input type="submit" value="Add" />
            </div>   
        </form>
        
    </body>
</html>
