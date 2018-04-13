
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello , Please Login !</h1>
        <h4>${message}</h4> 
        <h4>${fullname}</h4> 
        <form action="btnLogin.htm" method="post">
            <div>User name</div>
            <input type="text" name="username" value=""/>
            <div>Password</div>
            <input type="password" name="password" value=""/>
            <hr>
            <input type="submit" name="btnLogin" value="Login"/>
        </form>
    </body>
</html>
