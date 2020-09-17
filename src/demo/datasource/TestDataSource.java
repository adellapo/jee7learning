package demo.datasource;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/testDataSource")
public class TestDataSource extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jee7afondoDS")
	private DataSource ds;
	
    public TestDataSource() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PreparedStatement ps;
		ResultSet rs;
		String sql ="SELECT * FROM inscripcion";
		
		try(Connection con = ds.getConnection()) {
			
			PrintWriter pw = response.getWriter();
			
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			pw = response.getWriter();

			pw.println("<html><body>");
			pw.println("<ul>");
			while (rs.next()) {
				pw.println("<li>" + rs.getInt("id_inscripcion") + " " + rs.getString("nombre") + "</li>");
			}
			pw.println("</ul>");
			pw.println("</body></html>");
			
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
