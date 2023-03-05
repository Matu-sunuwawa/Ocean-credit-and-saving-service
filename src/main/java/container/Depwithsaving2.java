package container;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Depwithsaving2
 */
public class Depwithsaving2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//--------------------------------------withdraw-----------------------------------//
		PrintWriter out1=response.getWriter();
		response.setContentType("text/html");
		int with=Integer.parseInt(request.getParameter("swithamt"));
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advproject","root","");
			PreparedStatement ps=con.prepareStatement("select * from saving");
			ResultSet rs=ps.executeQuery();
			
			rs.next();
			int amt=Integer.parseInt(rs.getString("camt"));

		
		if(with==0)
		{
			out1.println("THERE IS NO SUCH CREDIT INTERRUPTED!!"+"<br><br>");
			out1.println("<a href=savingacc.jsp style=text-decoration:none;><font color=orange>CONTINUE......</a>");
		}
		else if(with<0)
		{
			out1.println("THERE IS NO SUCH WITHDRAW  INTERRUPTED!!");
			out1.println("...............................PLEASE DO NOT INTERRUPTE THE SYSTEM!!!"+"<br><br>");
			out1.println("<a href=savingacc.jsp style=text-decoration:none;><font color=orange>CONTINUE......</a>");
		}
		else if(with>amt)
		{
			out1.println("...............................BALANCE CAN NOT BE NEGATIVE   INTERRUPTED!!"+"<br><br>");
			out1.println("<a href=savingacc.jsp style=text-decoration:none;><font color=orange>CONTINUE......</a>");
		}
		else if(with<=amt)
		{
			
				
				int newwith=amt-with;
				PreparedStatement ps2=con.prepareStatement("update saving set camt=? where id=?");

				ps2.setInt(1, newwith);
				ps2.setInt(2, 1);
				int i= ps2.executeUpdate();
				
				if(i>0)
				{
					out1.println("YOU ARE SUCCESSFUL." +"<br><br>");
					out1.println("<a href=savingacc.jsp style=text-decoration:none;><font color=orange>CONTINUE......</a>");
				}		

		}
		
		con.close();
	} 
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}

}
