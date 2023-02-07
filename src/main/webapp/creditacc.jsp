<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="creditacc.css">
<title>Credit And Saving</title>
</head>
<body>

	<%
		if(session.getAttribute("button")==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("selectacc.jsp");
			rd.forward(request, response);
		}
	%>

    <section class="select">
        <div class="selection">
            <h2>Select the Account you want to access</h2>
            <form class="form" action="Creditacc">
                <div class="view">
                    <input type="submit" value="View Balance" name="test">
                </div>
            </form>
            
			<form class="form" action="Depwithcredit2" method="post">
				<div class="wdraw">
                    <input type="submit" value="Withdraw Funds" name="cwithdraw">
                    <input type="number"  name="cwithamt" placeholder="AMOUNT YOU WANT TO WITHDRAW FROM CREDIT ACCOUNT" required>
                </div>
            </form>
            
			<form class="form" action="Depwithcredit" method="post">
				<div class="dpost">
                    <input type="submit" value="Deposit Funds" name="cdeposit">
                    <input type="number" name="cdepamt" placeholder="AMOUNT YOU WANT TO DEPOSITE FROM CREDIT ACCOUUNT" required>
                </div>
            </form>
            
            <form class="form" action="Creditacc">
                <input type="submit" value="Cancel" name="test">
            </form>
        </div>
    </section>
</body>
</html>