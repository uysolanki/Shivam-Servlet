

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginHttpSessionServlet
 */
@WebServlet("/LoginHttpSessionServlet")
public class LoginHttpSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHttpSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("t1");
		String password= request.getParameter("t2");
		out.print("<h1> Http Session Welcomes ," +username + "</h1>");
		
		HttpSession session=request.getSession(true);
		System.out.println("default InactiveInterval" + session.getMaxInactiveInterval()/60 +  " minutes");
		
		session.setMaxInactiveInterval(60);
		
		System.out.println("updated InactiveInterval " + session.getMaxInactiveInterval()/60 +  " minutes");
		session.setAttribute("loggedinuser", username);
		session.setAttribute("logintime", new Date());
		
		out.print("<a href='shopses'> GO TO SHOPPING PAGE </a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
