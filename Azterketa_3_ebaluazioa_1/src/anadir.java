

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class anadir
 */
@WebServlet("/anadir")
public class anadir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	  static final String DB_URL = "jdbc:mysql://localhost/azterketa_3";
	  static final String USER = "root";
	  static final String PASS = "zubiri";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public anadir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String dni = request.getParameter("dni");
	    String apellido = request.getParameter("apellido");
	    
	    Connection conn = null;
	    Statement stmt = null;
	        	
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    try {
	    	conn = DriverManager.getConnection("jdbc:mysql://localhost/azterketa_3", "root", "zubiri");
	
			stmt = conn.createStatement();
		
			String sqlTabla = "CREATE TABLE IF NOT EXISTS matriculaciones (dni VARCHAR(9) ,apellido VARCHAR(50), PRIMARY KEY ( dni ))";

			stmt.executeUpdate(sqlTabla);
			
			String sqlInsert = "INSERT INTO matriculaciones (dni,apellido)" + "VALUES ('" + dni + "','" + apellido + "')";
	
			stmt.executeUpdate(sqlInsert);
	
		      String sqlSelect = "SELECT * FROM matriculaciones";
		      ResultSet rs = stmt.executeQuery(sqlSelect);
		      out.println("<html>");
		      out.println("<head>");
		      out.println("<title>Matriculaciones</title>");
		      out.println("</head>");
		      out.println("<body>");
		      out.println("<h1>MATRICULACIONES</h1>");
		      out.println("<table>");
		      out.println("<td> DNI </td>");
		      out.println("<td> APELLIDO </td>");
		      out.println("</tr>");
		      while (rs.next()) {
		    	String dniSelect = rs.getString("dni");
		        String apellidoSelect = rs.getString("apellido"); 
		        out.println("<tr>");
		        out.println("<td>" + dniSelect + "</td>");
		        out.println("<td>" + apellidoSelect + "</td>");
		        out.println("</tr>");
		      }
		      rs.close();
		      out.println("</table");
		      out.println("</body>");
		      out.println("</html>");
	      } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	      }
	    }	    
}
