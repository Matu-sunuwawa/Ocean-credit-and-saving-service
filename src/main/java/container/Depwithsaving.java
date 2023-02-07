package container;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

/**
 * Servlet implementation class Depwithsaving
 */
public class Depwithsaving extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out1=response.getWriter();
		response.setContentType("text/html");
		int dep=Integer.parseInt(request.getParameter("sdepamt"));
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advproject","root","");
			PreparedStatement ps=con.prepareStatement("select * from saving");
			ResultSet rs=ps.executeQuery();
			
			rs.next();
			int amt=Integer.parseInt(rs.getString("camt"));

		
		if(dep==0)
		{
			out1.println("THERE IS NO SUCH DEPOSIT INTERRUPTED!!"+"<br><br>");
			out1.println("<a href=savingacc.jsp style=text-decoration:none;><font color=orange>CONTINUE......</a>");
		}
		else if(dep<0)
		{
			out1.println("THERE IS NO SUCH DEPOSIT  INTERRUPTED!!");
			out1.println("...............................PLEASE DO NOT INTERRUPTE THE SYSTEM!!!"+"<br><br>");
			out1.println("<a href=savingacc.jsp style=text-decoration:none;><font color=orange>CONTINUE......</a>");
		}
		else if(dep>0)
		{

				
				int newdep=amt+dep;
				PreparedStatement ps2=con.prepareStatement("update saving set camt=? where id=?");

				ps2.setInt(1, newdep);
				ps2.setInt(2, 1);
				int i= ps2.executeUpdate();
				
				if(i>0)
				{
					out1.println("YOU ARE SUCCESSFUL." +"<br><br>");
					out1.println("<a href=savingacc.jsp style=text-decoration:none;><font color=orange>CONTINUE......</a>");
				}		

		}
	} 
	catch(Exception e)
	{
		e.printStackTrace();
	}

}}
