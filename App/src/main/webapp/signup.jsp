<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import ="java.net.URLDecoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
</head>
<body>
    <% Cookie[] cookies = null;
    cookies=request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("errorInName")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
 %>
                <div class="error-message">
                    <%= URLDecoder.decode(cookie.getValue(), "UTF-8") %>
                </div>
 <%        }if (cookie.getName().equals("errorInPassword")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
 %>
                <div class="error-message">
                    <%= URLDecoder.decode(cookie.getValue(), "UTF-8") %>
                </div>
 <%        }
        }
    }
 %>
	<form action="Signup" method="post">

		Enter UserName : <input type="text" name="username"> <br>
		Enter Password : <input type="password" name="password"> <br>
		<input type="submit" value="signin">
	</form>

</body>
</html>