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
			RequestDispatcher rd=request.getRequestDispatcher("selectacc.jsp");
			rd.forward(request, response);
		}
	%>

    <section class="select">
        <div class="selection">
            <h2>Select the Account you want to access</h2>
            <form class="form" action="Savingacc">
                <div class="view">
                    <input type="submit" value="View Balance" name="test">
                </div>
            </form>
            
			<form class="form" action="Depwithsaving2" method="post">
				<div class="wdraw">
                    <input type="submit" value="Withdraw Funds" name="test">
                    <input type="number" name="swithamt" placeholder="AMOUNT YOU WANT TO WITHDRAW FROM SAVING ACCOUNT"  required>
                </div>
			</form>
			
			<form class="form" action="Depwithsaving" method="post">
				<div class="dpost">
                    <input type="submit" value="Deposit Funds" name="test">
                    <input type="number" name="sdepamt" placeholder="AMOUNT YOU WANT TO DEPOSITE FROM SAVING ACCOUUNT" required>
                </div>
			</form>
			
			<form class="form" action="Savingacc">
                <input type="submit" value="Cancel" name="test">
			</form>
        </div>
    </section>
</body>
</html>