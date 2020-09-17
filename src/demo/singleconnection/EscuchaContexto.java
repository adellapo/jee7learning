package demo.singleconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EscuchaContexto implements ServletContextListener {

	public EscuchaContexto() {
	}

	public void contextInitialized(ServletContextEvent sce) {

		// variables
		String url = "jdbc:mysql://localhost/cursos";
		String driver = "com.mysql.cj.jdbc.Driver";
		String usr = "root";
		String pwd = "MyNewPass";
		Connection con;

		try {

			System.out.println("Intentando levantar el driver...");
		
			Class.forName(driver);

			con = DriverManager.getConnection(url, usr, pwd);

			// adjunto la conexion
			sce.getServletContext().setAttribute("con", con);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {

		// variables
		Connection con;
		ServletContext ctx;

		try {

			ctx = sce.getServletContext();

			con = (Connection) ctx.getAttribute("con");

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
