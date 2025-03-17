

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HitCountServlet
 */
@WebServlet("/HitCountServlet")
public class HitCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie cookies[]=request.getCookies();
		
		int visit=1;
		if(cookies==null)
		{
			out.print(visit + " visit");
			Cookie cookie =new Cookie("hitcount1",String.valueOf(visit));  //hitcount "1"
			response.addCookie(cookie);
		}
		else
		{
			for(Cookie c:cookies)
			{
				if(c.getName().equals("hitcount1"))
				{
					visit=Integer.parseInt(c.getValue());  //visit 2
					visit++;                               //visit 3
					out.print(visit + "visit");            //3 visit
					c.setValue(String.valueOf(visit));		//hitcount "3"
					c.setMaxAge(60*60*24*365*5*1000);
					response.addCookie(c);
					
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
