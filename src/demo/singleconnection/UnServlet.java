package demo.singleconnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/unServlet")
public class UnServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UnServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// variables
		String url = "jdbc:mysql://localhost/cursos";
		String driver = "com.mysql.cj.jdbc.Driver";
		String usr = "root";
		String pwd = "MyNewPass";
		Connection con;
		PrintWriter pw;
		String sql = "SELECT * FROM inscripcion";
		PreparedStatement ps;
		ResultSet rs;

		try {

			System.out.println("Intentando levantar el driver...");

			Class.forName(driver);

			con = DriverManager.getConnection(url, usr, pwd);

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			pw = response.getWriter();

			pw.println("<html><body>");
			pw.println("<p>Este es un ejemplo de thread safe pues cada conexion se realiza al momento de instanciar el Servlet. Distinto a el caso de la conexion a apartir del contexto en la que se realiza una conexion y luego esta es compartida por el contexto.</p><hr><br>");
			pw.println("<ul>");
			while (rs.next()) {
				pw.println("<li>" + rs.getInt("id_inscripcion") + " " + rs.getString("nombre") + "</li>");
			}
			pw.println("</ul>");
			pw.println("</body></html>");

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
