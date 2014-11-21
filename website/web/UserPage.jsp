<%-- 
    Document   : UserPage
    Created on : Nov 20, 2014, 5:15:16 PM
    Author     : Dakota
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //Check for current user and sets user if currently loged in.
            //Redirects to home page if not logged in and attempted
            // to access page directly
            String currentUser = null;
            if (session.getAttribute("currentUser") == null) {
                response.sendRedirect("HomePage.jsp");
            } else {
                currentUser = (String) session.getAttribute("user");
            }
        %>
        <h1>User Page</h1>
        <p>You are Logged in as ${currentUser}</p>
        <form action="${pageContext.request.contextPath}/LogOut">
            <input type="submit" value="LogOut">
        </form>
    </body>
</html>
