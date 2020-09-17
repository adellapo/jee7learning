package demo.singleconnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usaConexion")
public class UsaConexion extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UsaConexion() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// variables
		Connection con;
		ServletContext ctx;
		PrintWriter pw;
		String sql;
		PreparedStatement ps;
		ResultSet rs;

		try {

			ctx = request.getServletContext();

			con = (Connection) ctx.getAttribute("con");

			sql = "SELECT * FROM inscripcion;";

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			// obtengo el PrintWriter
			pw = response.getWriter();

			// pagina
			pw.println("<html><body>");
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
