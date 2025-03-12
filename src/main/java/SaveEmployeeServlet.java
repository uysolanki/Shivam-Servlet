

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveEmployeeServlet
 */
@WebServlet("/SaveEmployeeServlet")
public class SaveEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int a=Integer.parseInt(request.getParameter("t1"));
		String b= request.getParameter("t2");
		double c=Double.parseDouble(request.getParameter("t3"));
		
		Connection con;
		PreparedStatement ps;
		ServletContext context=getServletContext();
		try
		{
			String mySqlUrl=(String)context.getInitParameter("mysqlURL");
			String databasename=(String)context.getInitParameter("databasename");
			String username=(String)context.getInitParameter("databaseusername");
			String password=(String)context.getInitParameter("databasepassword");
			String drivername=(String)context.getInitParameter("databasedrivername");

			Class.forName(drivername); 
			
			con=DriverManager.getConnection(mySqlUrl+databasename,username,password);
			
			String query="insert into emp values(?,?,?)";
			ps=con.prepareStatement(query);
			
			ps.setInt(1, a);
			ps.setString(2, b);
			ps.setDouble(3, c);
			
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				out.print("<font color='green'>Record Inserted</font>");
				RequestDispatcher rd=request.getRequestDispatcher("/employee-registration-form.html");
				rd.include(request, response);
			}
			else
				out.print("Record Not Inserted");
			
			ps.close();
			con.close();
			
		}
		catch(ClassNotFoundException | SQLException e1)
		{
			out.print(e1.getMessage());
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
