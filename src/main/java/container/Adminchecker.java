package container;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Adminchecker
 */
public class Adminchecker extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advproject","root","");
			int n= Integer.parseInt(request.getParameter("aname"));
			String p= request.getParameter("apass");
			PreparedStatement ps=con.prepareStatement("select uname from Admins where uname=? and upass=?");
			ps.setInt(1, n);
			ps.setString(2, p);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("username", p);
				RequestDispatcher rd=request.getRequestDispatcher("selectacc.jsp");
				rd.forward(request, response);
			}
			else {
				out.println("LOGIN FAILED!!!<br>");
//				out.println("<a href=login.jsp>Tray Again!</a>");
				out.println("<a href=login.jsp style=text-decoration:none;><font color=orange>Try Again!!!</a>");
			}
			
			con.close();
//			-----------------------------  ,,  --------------------------------------
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
