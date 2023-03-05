<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="login.css">
<title>Credit And Saving</title>
</head>
<body>
    <section class="login">
        <div class="sign-in">
            <h2>WELCOME TO!<br> Ocean Credit And Saving Service</h2>
            <form class="form" action="ServletAct" method="post">
                <input type="number" name="uname" placeholder="Account Number" required><br>
                <input type="number" pattern="[0-9]*" inputmode="numeric" style="-webkit-text-security:disc;" name="pass" placeholder="Pin Number" required><br>
                <input type="submit" value="login">
            </form>
        </div>
    </section>
</body>
</html>