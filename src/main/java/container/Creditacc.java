package container;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class Creditacc
 */
public class Creditacc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String op=request.getParameter("test");
		
		if("View Balance".equals(op))
		{
			try 
			{
				String sql="select * from credit";
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advproject","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);	
				
				rs.next();
				int amt=Integer.parseInt(rs.getString("camt"));
				
				if(amt==0)
				{
					out.println("YOUR CREDIT AMOUNT IS: $"+(-1)*(amt) +"<br><br>");
					out.println("<a href=creditacc.jsp style=text-decoration:none;><font color=orange>CONTINUE......</a>");
				}
				else if((-1)*(amt)>0)
				{
					out.println("YOUR CREDIT AMOUNT IS: $" +(-1)*(amt) +"<br><br>");
					out.println("<a href=creditacc.jsp style=text-decoration:none;><font color=orange>CONTINUE......</a>");
				}
				else if((-1)*(amt)<0)
				{
					out.println("..............................BALANCE CAN NOT BE NEGATIVE!!!");
				}
				st.close();
				con.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
//		else if("Withdraw Funds".equals(op))
//		{
//			out.println("Your amount is:");
//		}
//		
//		else if("Deposit Funds".equals(op))
//		{
//			
//		}
		else if("Cancel".equals(op))
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
