<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="selectacc.css">
<title>Credit And Saving</title>
</head>
<body>

	<%
		if(session.getAttribute("username")==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	%>

    <section class="select">
        <div class="selection">
            <h2>Select the Account you want to access</h2>
            <form class="form" action="Selection" method="post">
                <input type="submit" value="Credit Account" name="test">
				<input type="submit" value="Saving Account" name="test"><br>
				<input type="submit" value="Cancel" name="test">
            </form>
        </div>
    </section>
</body>
</html>