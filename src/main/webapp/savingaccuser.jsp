<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="savingacc.css">
<title>Credit And Saving</title>
</head>
<body>

	<%
		if(session.getAttribute("button")==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("selectaccuser.jsp");
			rd.forward(request, response);
		}
	%>

    <section class="select">
        <div class="selection">
            <h2>Select the Account you want to access</h2>
            <form class="form" action="Savingaccuser">
                <div class="view">
                    <input type="submit" value="View Balance" name="test">
                </div>
            </form>
			
			<form class="form" action="Savingaccuser">
                <input type="submit" value="Cancel" name="test">
			</form>
        </div>
    </section>
</body>
</html>