

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginHiddenFieldsServlet
 */
@WebServlet("/LoginHiddenFieldsServlet")
public class LoginHiddenFieldsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHiddenFieldsServlet() {
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
		out.print("<h1> Hidden Fields Welcomes ," +username + "</h1>");
		
		//out.print("<a href='shop?zzz="+username+"'>GO TO SHOPPING PAGE</a>");  
		
		out.print("<form action='shophf' method='post'>");
		out.print("<input type='hidden' name='tx'  value='"+username+"'><br>");
		out.print("<input type='submit' name='s1' value='GO TO SHOPPING PAGE'>");
		out.print("</form");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
