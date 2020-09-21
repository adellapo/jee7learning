package demo.jndi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testJNDIServlet")
public class TestJNDIServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TestJNDIServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String jndiName = "";
			
			jndiName = request.getParameter("jndiName");
			
			Context ctx = new InitialContext();
			
			PrintWriter pw = response.getWriter();
			
			JndiTreeInspector.inspect(ctx, jndiName, pw);
			
		} catch (Exception e) {
		
		}
		
	}

}
