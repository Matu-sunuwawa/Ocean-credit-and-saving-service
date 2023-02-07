package container;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Selection
 */
public class Selection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selection() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String op=request.getParameter("test");
			
		if("Credit Account".equals(op))
		{
			HttpSession session=request.getSession();
			session.setAttribute("button", op);
			RequestDispatcher rd=request.getRequestDispatcher("creditacc.jsp");
			rd.forward(request, response);
		}
		else if("Saving Account".equals(op))
		{
			HttpSession session=request.getSession();
			session.setAttribute("button", op);
			RequestDispatcher rd=request.getRequestDispatcher("savingacc.jsp");
			rd.forward(request, response);
		}
		else if("Cancel".equals(op))
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
